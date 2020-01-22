package com.crud.Supermarket.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "customer")
public class Customer implements Serializable{

	@Id
	@Column(name = "customer_id", unique = true, nullable = false)
	private String customer_id;
	
	@NotBlank
	@Column(name = "customername")
	private String customername;
	
	@Column(name = "phone")
	private int phone;
	
	@Column(name = "address")
	private String address;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<BillEntity> bills = new ArrayList<>();
	
	public Customer(String customer_id, @NotBlank String customername, int phone, String address) {
		super();
		this.customer_id = customer_id;
		this.customername = customername;
		this.phone = phone;
		this.address = address;
	}

	public Customer() {
	}

	public String getCustomerid() {
		return customer_id;
	}

	public void setCustomerid(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customername=" + customername + ", phone=" + phone
				+ ", address=" + address + "]";
	}
}
