package com.crud.Supermarket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.Supermarket.dto.BillDTO;
import com.crud.Supermarket.dto.BillProductDTO;
import com.crud.Supermarket.exception.RecordNotFoundException;
import com.crud.Supermarket.model.BillEntity;
import com.crud.Supermarket.model.BillProductEntity;
import com.crud.Supermarket.model.Customer;
import com.crud.Supermarket.model.ProductEntity;
import com.crud.Supermarket.repository.BillProductRepository;
import com.crud.Supermarket.repository.BillRepository;
import com.crud.Supermarket.repository.CustomerRepository;
import com.crud.Supermarket.repository.ProductRepository;

@Service
@Transactional
public class BillService {

	@Autowired
	BillRepository billRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	BillProductRepository billProductRepository;
	
	public List<BillEntity> getAllBills() {
		List<BillEntity> billList = billRepository.findAll();
		
		if(billList.size() > 0) {
			return billList;
		} else {
			return new ArrayList<BillEntity>();
		}
	}
	
	public BillEntity getBillById(String id) throws RecordNotFoundException {
		Optional<BillEntity> bill = billRepository.findById(id);
		
		if(bill.isPresent()) {
			return bill.get();
		}
		else {
			throw new RecordNotFoundException("No bill record exist for given id", id);
		}
	}
	
//	public BillDTO createOrUpdateBill(BillDTO entity) throws RecordNotFoundException {
//		
////		ProductEntity product = productRepository.getOne(entity.);
//		Customer customer = customerRepository.getOne(entity.getCustomer_id());
//		
//		if(entity.getBill_no()!=null) {
//			for (BillProductDTO dto : entity.getBillProducts()) {
//				Optional<Bill> bill = billRepository.findById(entity.getBill_no());
//			}
//			
//			
//			if(bill.isPresent()) {
//				BillDTO newEntity = bill.get();
//				newEntity.setBill_no(entity.getBill_no());
//				newEntity.setTotalPrice(entity.getTotalPrice());
//				
//				newEntity = billRepository.save(new BillEntity(entity.getBill_no(), entity.getTotalPrice(), customer));
//				
//				return newEntity;
//			} else {
//				entity = billRepository.save(entity);
//				
//				return entity;
//			}
//		}
//		
//		else {
//			entity = billRepository.save(entity);
//			return entity;
//		}
//	}
	
//	public String createBill(BillDTO bill) {
//		Customer customer = customerRepository.getOne(bill.getCustomer_id());
////		ProductEntity product = productRepository.getOne(bill.getProduct_id());
//		System.out.println(customer);
//		BillEntity billEntity = billRepository.save(new BillEntity(bill.getBill_no(), bill.getTotalPrice(), customer, product));
//		System.out.println(billEntity);
//		for (BillProductDTO dto: bill.getBillProducts()) {
////			ProductEntity product = productRepository.getOne(dto.getProduct_id());
//			BillProductEntity ids = billProductRepository.save(new BillProductEntity(dto.getQuantity(), product, billEntity));
//			System.out.println("ids ---- " + ids);
//			int qty = product.getQuantity() - dto.getQuantity();
//			product.setQuantity(qty);
//		}
//		return billEntity.getBill_no();
//	}
	

	
	public String createBill(BillDTO bill) {
		Customer customer = customerRepository.getOne(bill.getCustomer_id());
		
		float total = 0;
		
		for(BillProductDTO dto : bill.getBillProducts()) {
			
			billProductRepository.save(new BillProductEntity(dto.getBill_no(), dto.getProduct_id(), dto.getQuantity()));
			//int quantity = dto.getQuantity();
			ProductEntity productEntity = productRepository.getOne(dto.getProduct_id());
//			float mrp = productRepository.getProductPrice(dto.getProduct_id());
//			total = mrp * dto.getQuantity();
			int qty = productEntity.getQuantity() - dto.getQuantity();
			productEntity.setQuantity(qty);
			float itemPrice=productEntity.getPrice();
			
			float totalItemprice=itemPrice*dto.getQuantity();
			total+=totalItemprice;
		}
		String id = billRepository.save(new BillEntity(bill.getBill_no(), total, customer)).getBill_no();	
		return id;
	}
	
	public void deleteBillById(String id) throws RecordNotFoundException {
		Optional<BillEntity> bill = billRepository.findById(id);
		
		if(bill.isPresent()) {
			billRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No bill record exist for given id", id);
		}
	}
}
