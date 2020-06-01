package com.example.demo.controlller;

import com.example.demo.model.Orders;
import com.example.demo.services.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping(path = "/", produces = "application/json")
    public ResponseEntity<List<Orders>> getAllOrders(){
        List<Orders> list = orderService.findAll();
        return new ResponseEntity<List<Orders>>(list, new HttpHeaders(), HttpStatus.OK);

    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Integer> insertOrders(@RequestBody Orders order){
        Orders insertedOrders =  orderService.insertOrder(order);
        return new ResponseEntity<Integer>(insertedOrders.getOrderId(),new HttpHeaders(), HttpStatus.CREATED);

    }

    @PutMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Integer> updateOrders(@RequestBody Orders order){
        Orders updated =  orderService.updateOrder(order);
        return new ResponseEntity<Integer>(updated.getOrderId(),new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Integer> deleteOrders(@RequestBody Orders order){
        orderService.deleteOrder(order);
        return new ResponseEntity<Integer>(null,new HttpHeaders(), HttpStatus.NO_CONTENT);
    }
}
