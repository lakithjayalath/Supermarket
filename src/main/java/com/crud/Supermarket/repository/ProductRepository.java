package com.crud.Supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crud.Supermarket.model.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{
	
//	@Query(value = "select p.price from product p where p.product_id = :product_id")
//	float getProductPrice(@Param("product_id")int product_id);

}
