package com.example.demo.repositories;

import com.example.demo.model.CustOrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	Customer findByFirstName(String firstname);

	@Procedure("GetCustCount")
	int getTotalCustCount(String name);

	@Query("select c.firstName,o.orderId from Customer c ,Orders o where c.customerId=o.customerId")
	public List<CustOrderInfo> findCustWithOrders();


}
