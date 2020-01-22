package com.crud.Supermarket.dto;

public class CustomerDTO {

	private String customer_id;
	private String customername;
	private int phone;
	private String address;
	
	public CustomerDTO() {
		
	}

	public CustomerDTO(String customer_id, String customername, int phone, String address) {
		this.customer_id = customer_id;
		this.customername = customername;
		this.phone = phone;
		this.address = address;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
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
		return "CustomerDTO [customer_id=" + customer_id + ", customername=" + customername + ", phone=" + phone
				+ ", address=" + address + "]";
	}
	
}
