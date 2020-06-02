package com.example.demo.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @GetMapping(path = "/hello", produces = "application/json")
    public ResponseEntity<String> sayHello(){

        return new ResponseEntity<String>("Hello World", new HttpHeaders(), HttpStatus.OK);

    }
}
