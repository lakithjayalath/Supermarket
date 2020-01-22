package com.crud.Supermarket.repository;

//
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//
import com.crud.Supermarket.model.BillProductEntity;
import com.crud.Supermarket.model.BillProductPK;
//import com.crud.Supermarket.model.BillProductPK;

@Repository
public interface BillProductRepository extends JpaRepository<BillProductEntity, BillProductPK>{
//
//	Optional<BillProductEntity> findById(String billNo, int productId);
//
}
