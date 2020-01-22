package com.crud.Supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.Supermarket.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{

}
