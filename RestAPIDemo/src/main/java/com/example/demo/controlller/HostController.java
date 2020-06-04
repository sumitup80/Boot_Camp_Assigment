package com.example.demo.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Message;

@RestController
public class HostController {

    @GetMapping(path = "/hostname", produces = "application/json")
    public ResponseEntity<Message> getHostName() throws UnknownHostException{
        Message msg = new Message(InetAddress.getLocalHost().getHostName());
        return new ResponseEntity<Message>(msg, new HttpHeaders(), HttpStatus.OK);

    }
}
