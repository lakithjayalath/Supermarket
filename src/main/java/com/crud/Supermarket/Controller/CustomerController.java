package com.crud.Supermarket.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.Supermarket.exception.RecordNotFoundException;
import com.crud.Supermarket.model.Customer;
import com.crud.Supermarket.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerService service;
	
	@GetMapping
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> list = service.getAllCustomers();
		return new ResponseEntity<List<Customer>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") String id) {
		
		Customer entity = service.getCustomerById(id);
		
		return new ResponseEntity<Customer>(entity, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Customer> createOrUpdateProduct(@Valid @RequestBody Customer customer) throws RecordNotFoundException{
		
		Customer updated = service.createOrUpdateCustomer(customer);
		return new ResponseEntity<Customer>(updated, new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public HttpStatus deleteCustomerById(@PathVariable("id") String id) throws RecordNotFoundException {
		
		service.deleteCustomerById(id);
		return HttpStatus.FORBIDDEN;
	}
	
}
