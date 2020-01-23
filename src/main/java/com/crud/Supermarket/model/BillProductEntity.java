package com.crud.Supermarket.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "billproduct")
public class BillProductEntity implements Serializable {
	
	@EmbeddedId
	private BillProductPK billProductPK;

//	@Id
//	@Column(insertable=false, updatable=false)
//	private String bill_no;
//	@Id
//	@Column(insertable=false, updatable=false)
//	private int product_id;
	
//	@Column(name = "productname")
//	private String productname;
	
	@ManyToOne
	@JoinColumn(name = "billno", referencedColumnName = "bill_no",insertable = false,updatable = false)
	private BillEntity bill;
	
	@ManyToOne
	@JoinColumn(name = "productid", referencedColumnName = "product_id",insertable = false,updatable = false)
	private ProductEntity product;
	
	@Column(name = "quantity")
	private int quantity;
	
	public BillProductEntity() {
		
	}

	public BillProductEntity(BillProductPK billProductPK, int quantity) {
		this.billProductPK = billProductPK;
		this.quantity = quantity;
	}
	
	public BillProductEntity(String bill_no, int product_id, int quantity) {
		this.billProductPK = new BillProductPK(bill_no, product_id);
		this.quantity = quantity;
	}
	
	public BillProductEntity( int quantity, ProductEntity product, BillEntity bill) {
		this.quantity = quantity;
		this.product = product;
		this.bill = bill;
	}

//	public BillProductEntity( String bill_no,int product_id, int quantity) {
//		super();
//		this.bill_no = bill_no;
//		this.product_id = product_id;
//		this.quantity = quantity;
//	}
	
//	public BillProductEntity(String bill_no, Long product_id, int quantity, ProductEntity product,
//			BillEntity bill) {
//		super();
//		this.billProductPK = new BillProductPK(bill_no, product_id);
//		this.quantity = quantity;
//		this.product = product;
//		this.bill = bill;
//	}

	public ProductEntity getProduct() {
		return product;
	}

//	public BillProductEntity(BillProductPK billProductPK, String bill_no, int product_id, int quantity,
//			ProductEntity product, BillEntity bill) {
//		super();
//		this.billProductPK =billProductPK;
//		this.bill_no = bill_no;
//		this.product_id = product_id;
//		this.quantity = quantity;
//		this.product = product;
//		this.bill = bill;
//	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

//	public String getBill_no() {
//		return bill_no;
//	}
//
//	public void setBill_no(String bill_no) {
//		this.bill_no = bill_no;
//	}
//
//	public int getProduct_id() {
//		return product_id;
//	}
//
//	public void setProduct_id(int product_id) {
//		this.product_id = product_id;
//	}

	public BillProductPK getBillProductPK() {
		return billProductPK;
	}

	public void setBillProductPK(BillProductPK billProductPK) {
		this.billProductPK = billProductPK;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BillEntity getBillEntity() {
		return bill;
	}

	public void setBillEntity(BillEntity billEntity) {
		this.bill = billEntity;
	}

	public BillEntity getBill() {
		return bill;
	}

	public void setBill(BillEntity bill) {
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "BillProductEntity [billProductPK=" + billProductPK + ", quantity=" + quantity + "]";
	}
	
}
