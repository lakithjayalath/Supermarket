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
import com.crud.Supermarket.model.ProductEntity;
import com.crud.Supermarket.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping
	public ResponseEntity<List<ProductEntity>> getAllProducts() {
		List<ProductEntity> list = service.getAllProducts();
		return new ResponseEntity<List<ProductEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductEntity> getProductById(@PathVariable("id") int id) {
		
		ProductEntity entity = service.getProductById(id);
		
		return new ResponseEntity<ProductEntity>(entity, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ProductEntity> createOrUpdateProduct(@Valid @RequestBody ProductEntity product) throws RecordNotFoundException{
		
		ProductEntity updated = service.createOrUpdateProduct(product);
		return new ResponseEntity<ProductEntity>(updated, new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public HttpStatus deleteProductById(@PathVariable("id") int id) throws RecordNotFoundException {
		
		service.deleteProductById(id);
		return HttpStatus.FORBIDDEN;
	}
	
}
