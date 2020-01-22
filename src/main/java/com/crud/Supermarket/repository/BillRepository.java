package com.crud.Supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.Supermarket.model.BillEntity;

@Repository
public interface BillRepository extends JpaRepository<BillEntity, String>{

}
