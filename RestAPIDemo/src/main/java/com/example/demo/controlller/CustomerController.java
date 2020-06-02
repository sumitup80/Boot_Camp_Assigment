package com.example.demo.controlller;

import com.example.demo.model.CustOrderInfo;
import com.example.demo.model.Customer;
import com.example.demo.services.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customer")

public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PreAuthorize("hasRole('USER')")
	@GetMapping(path = "/", produces = "application/json")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> list = customerService.findAll();
		return new ResponseEntity<List<Customer>>(list, new HttpHeaders(), HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Integer> insertCustomer(@RequestBody Customer customer){
		Customer insertedCustomer =  customerService.insertCustomer(customer);
		return new ResponseEntity<Integer>(insertedCustomer.getCustomerId(),new HttpHeaders(), HttpStatus.CREATED);
		
	}
	
	@PutMapping(path = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Integer> updateCustomer(@RequestBody Customer customer){
		Customer updated =  customerService.updateCustomer(customer);
		return new ResponseEntity<Integer>(updated.getCustomerId(),new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Integer> deleteCustomer(@RequestBody Customer customer){
		customerService.deleteCustomer(customer);
		return new ResponseEntity<Integer>(null,new HttpHeaders(), HttpStatus.NOT_FOUND);
		
	}

	@GetMapping("/count/{name}")
	public ResponseEntity<Integer> getCustCount(@PathVariable(value = "name")String firstName){
		int count = customerService.getCustCountWithFirstName(firstName);
		return  new ResponseEntity<Integer>(count,HttpStatus.OK);
	}

	@GetMapping("/custorders")
	public ResponseEntity<List<CustOrderInfo>> getCustCount(){
		List<CustOrderInfo> custOrderList= customerService.getAllCustWithOrders();
		return  new ResponseEntity<List<CustOrderInfo>>(custOrderList,HttpStatus.OK);
	}
}
