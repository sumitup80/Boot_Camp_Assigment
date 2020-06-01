package com.example.demo.services.interfaces;

import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer insertCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    Integer deleteCustomer(Customer customer);


}
