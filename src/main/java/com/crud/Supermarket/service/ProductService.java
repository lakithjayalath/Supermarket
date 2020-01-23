package com.crud.Supermarket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.Supermarket.exception.RecordNotFoundException;
import com.crud.Supermarket.model.ProductEntity;
import com.crud.Supermarket.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	ProductRepository repository;
	
	public List<ProductEntity> getAllProducts() {
		List<ProductEntity> productList = repository.findAll();
		
		if(productList.size() > 0) {
			return productList;
		} else {
			return new ArrayList<ProductEntity>();
		}
	}
	
	public ProductEntity getProductById(int id) throws RecordNotFoundException {
		Optional<ProductEntity> product = repository.findById(id);
		
		if(product.isPresent()) {
			return product.get();
		}
		else {
			throw new RecordNotFoundException("No product record exist for given id", id);
		}
	}
	
	public ProductEntity createOrUpdateProduct(ProductEntity entity) throws RecordNotFoundException {
		
		if(entity.getProduct_id()!=0) {
			Optional<ProductEntity> product = repository.findById(entity.getProduct_id());
			
			if(product.isPresent()) {
				ProductEntity newEntity = product.get();
				newEntity.setProduct_id(entity.getProduct_id());
				newEntity.setProduct_name(entity.getProduct_name());
				newEntity.setPrice(entity.getPrice());
				newEntity.setQuantity(entity.getQuantity());
				newEntity.setCategory(entity.getCategory());
				
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
	
	public void deleteProductById(int id) throws RecordNotFoundException {
		Optional<ProductEntity> product = repository.findById(id);
		
		if(product.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No product record exist for given id", id);
		}
	}
}
