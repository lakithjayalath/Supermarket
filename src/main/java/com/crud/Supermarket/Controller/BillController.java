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

import com.crud.Supermarket.dto.BillDTO;
import com.crud.Supermarket.exception.RecordNotFoundException;
import com.crud.Supermarket.model.BillEntity;
import com.crud.Supermarket.service.BillService;

@RestController
@RequestMapping("/bills")
public class BillController {

	@Autowired
	BillService service;
	
	@GetMapping
	public ResponseEntity<List<BillEntity>> getAllBills() {
		List<BillEntity> list = service.getAllBills();
		return new ResponseEntity<List<BillEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BillEntity> getBillById(@PathVariable("id") String id) {
		
		BillEntity entity = service.getBillById(id);
		return new ResponseEntity<BillEntity>(entity, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<String> createOrUpdateBill(@Valid @RequestBody BillDTO bill) throws RecordNotFoundException{
		
		String updated = service.createBill(bill);
		return new ResponseEntity<String>(new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public HttpStatus deleteBillById(@PathVariable("id") String id) throws RecordNotFoundException {
		
		service.deleteBillById(id);
		return HttpStatus.FORBIDDEN;
	}
	
}
