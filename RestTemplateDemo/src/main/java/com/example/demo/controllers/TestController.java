package com.example.demo.controllers;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/test")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(path = "/abc", produces = "application/json")
    public ResponseEntity<Customer[]> findAll(){
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor("admin", "admin"));
        Customer[] customers = restTemplate.getForObject("http://restapidemo/customer/",
                Customer[].class);
        return new ResponseEntity<Customer[]>(customers
                ,new HttpHeaders(), HttpStatus.OK);
    }
}
