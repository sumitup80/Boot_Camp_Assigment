package com.example.demo.services;

import com.example.demo.model.Address;
import com.example.demo.model.OrderDetail;
import com.example.demo.model.Orders;
import com.example.demo.repositories.OrderDetailRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.services.interfaces.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Order;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<Orders> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Orders insertOrder(Orders order) {
        Orders insertedOrder = orderRepository.save(order);
        /*for(OrderDetail orderDetail:order.getOrderDetail()) {
            *//*orderDetail.setOrderId(order.getOrderId());
            orderDetail.setOrders(order);*//*
            orderDetailRepository.save(orderDetail);
        }*/
        return insertedOrder;
    }

    @Override
    public Orders updateOrder(Orders order) {
        return orderRepository.save(order);
    }

    @Override
    public Integer deleteOrder(Orders order) {
        orderRepository.delete(order);
        return order.getOrderId();
    }
}
