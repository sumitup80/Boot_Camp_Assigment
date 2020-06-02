package com.example.demo.services;

import com.example.demo.model.Address;
import com.example.demo.model.CustOrderInfo;
import com.example.demo.model.Customer;
import com.example.demo.repositories.AddressRepository;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.services.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer insertCustomer(Customer customer) {
        Customer insertedCustomer =  customerRepository.save(customer);
        for(Address address:customer.getAddresses()) {
            address.setCustomerId(insertedCustomer.getCustomerId());
            address.setCustomer(insertedCustomer);
            addressRepository.save(address);

        }
        return insertedCustomer;
    }

    @Override
    public List<CustOrderInfo> getAllCustWithOrders() {
        return customerRepository.findCustWithOrders();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        for(Address address:customer.getAddresses()) {
            address.setCustomerId(customer.getCustomerId());
            address.setCustomer(customer);
        }
        Customer updated =  customerRepository.save(customer);
        return updated;
    }

    @Override
    public Integer deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
        return customer.getCustomerId();
    }
    @Override
    public int getCustCountWithFirstName(String name){
        return customerRepository.getTotalCustCount(name);
    }

}
