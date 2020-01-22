package com.crud.Supermarket.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "bill")
public class BillEntity implements Serializable{

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bill_no", unique = true, nullable = false)
	private String bill_no;
	
	@Column(name = "totalprice")
	private float totalprice;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
//	@OneToMany(mappedBy = "bill", cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
//	private ProductEntity product;

	@OneToMany(mappedBy = "bill", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	private List<BillProductEntity> billProduct = new ArrayList<>();
	
	public BillEntity() {
		
	}
	
	public BillEntity(String bill_no, float totalprice, Customer customer) {
		super();
		this.bill_no = bill_no;
		this.totalprice = totalprice;
		this.customer = customer;
	}
	
	public BillEntity(String bill_no, float totalprice, Customer customer, List<BillProductEntity> billProduct) {
		super();
		this.bill_no = bill_no;
		this.totalprice = totalprice;
		this.customer = customer;
		this.billProduct = billProduct;
	}

	public float getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}

	public List<BillProductEntity> getBillProduct() {
		return billProduct;
	}

	public void setBillProduct(List<BillProductEntity> billProduct) {
		this.billProduct = billProduct;
	}

	public float getTotalPrice() {
		return totalprice;
	}

	public void setTotalPrice(float totalprice) {
		this.totalprice = totalprice;
	}

	public String getBill_no() {
		return bill_no;
	}

	public void setBill_no(String bill_no) {
		this.bill_no = bill_no;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "BillEntity [bill_no=" + bill_no + ", totalprice=" + totalprice + ", customer=" + customer
				+ ", billProduct=" + billProduct + "]";
	}

	
	
}
