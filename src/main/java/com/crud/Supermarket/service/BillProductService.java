//package com.crud.Supermarket.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.crud.Supermarket.exception.RecordNotFoundException;
//import com.crud.Supermarket.model.BillEntity;
//import com.crud.Supermarket.model.BillProductEntity;
//import com.crud.Supermarket.model.BillProductPK;
//import com.crud.Supermarket.repository.BillProductRepository;
//
//@Service
//public class BillProductService {
//
//	@Autowired
//	BillProductRepository repository;
//	
//	public List<BillProductEntity> getAllBillProducts() {
//		List<BillProductEntity> billProductList = repository.findAll();
//		
//		if(billProductList.size() > 0) {
//			return billProductList;
//		} else {
//			return new ArrayList<BillProductEntity>();
//		}
//	}
//	
//	public BillProductEntity getBillById(String id, int productId) throws RecordNotFoundException {
//		Optional<BillProductEntity> billProduct = repository.findById(id, productId);
//		
//		if(bill.isPresent()) {
//			return bill.get();
//		}
//		else {
//			throw new RecordNotFoundException("No bill record exist for given id", id);
//		}
//	}
//	
//	public BillProductEntity createOrUpdateBillProduct(BillProductEntity entity) throws RecordNotFoundException {
//		
//		if(entity.getBillno()!=null && entity.getProductid()!=0) {
//			Optional<BillProductEntity> billProduct = repository.findById(entity.getBillno(), entity.getProductid());
//			
//			if(billProduct.isPresent()) {
//				BillProductEntity newEntity = billProduct.get();
//				newEntity.setBillno(entity.getBillno());
//				newEntity.setProductid(entity.getProductid());
//				newEntity.setProductname(entity.getProductname());
//				
//				newEntity = repository.save(newEntity);
//				
//				return newEntity;
//			} else {
//				entity = repository.save(entity);
//				
//				return entity;
//			}
//		}
//		
//		else {
//			entity = repository.save(entity);
//			return entity;
//		}
//	}
//	
//	public void deleteProductById(BillProductPK billProductPk) throws RecordNotFoundException {
//		Optional<BillProductEntity> billProduct = repository.findById(billProductPk.getBillNo(), billProductPk.getProductId());
//		
//		if(billProduct.isPresent()) {
//			repository.deleteById(billProductPk);
//		} else {
//			throw new RecordNotFoundException("No product record exist for given id");
//		}
//	}
//}
