package com.example.demo.services.interfaces;

import com.example.demo.model.Orders;

import java.util.List;

public interface OrderService {
    List<Orders> findAll();
    Orders insertOrder(Orders order);
    Orders updateOrder(Orders order);
    Integer deleteOrder(Orders order);
}
