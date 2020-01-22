package com.crud.Supermarket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.Supermarket.exception.RecordNotFoundException;
import com.crud.Supermarket.model.Customer;
import com.crud.Supermarket.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {

	@Autowired
	CustomerRepository repository;
	
	public List<Customer> getAllCustomers() {
		List<Customer> customerList = repository.findAll();
		
		if(customerList.size() > 0) {
			return customerList;
		} else {
			return new ArrayList<Customer>();
		}
	}
	
	public Customer getCustomerById(String id) throws RecordNotFoundException {
		Optional<Customer> customer = repository.findById(id);
		
		if(customer.isPresent()) {
			return customer.get();
		}
		else {
			throw new RecordNotFoundException("No customer record exist for given id", id);
		}
	}
	
	public Customer createOrUpdateCustomer(Customer entity) throws RecordNotFoundException {
		
		if(entity.getCustomerid()!=null) {
			Optional<Customer> customer = repository.findById(entity.getCustomerid());
			
			if(customer.isPresent()) {
				Customer newEntity = customer.get();
				newEntity.setCustomerid(entity.getCustomerid());
				newEntity.setCustomername(entity.getCustomername());
				newEntity.setPhone(entity.getPhone());
				newEntity.setAddress(entity.getAddress());
				
				newEntity = repository.save(newEntity);
				
				return newEntity;
			} else {
				entity = repository.save(entity);
				return entity;
			}
		}
		else {
			entity = repository.save(entity);
			return entity;
		}
	}
	
	public void deleteCustomerById(String id) throws RecordNotFoundException {
		Optional<Customer> customer = repository.findById(id);
		
		if(customer.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No customer record exist for given id", id);
		}
	}
}
