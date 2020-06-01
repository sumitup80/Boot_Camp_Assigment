package com.example.demo.services;

import com.example.demo.model.Customer;
import com.example.demo.model.CustomerList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class TestService {
    private final RestTemplate restTemplate;
    @Autowired
    public TestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

   public ResponseEntity<CustomerList> findAll(){
       return new ResponseEntity<CustomerList>(
               restTemplate.getForObject("http://restapidemo/customer",
                       CustomerList.class),new HttpHeaders(), HttpStatus.OK);
   }
}
