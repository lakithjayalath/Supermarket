package com.crud.Supermarket.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BillDTO {

	@JsonProperty("bill_no")
	private String bill_no;
	private String customer_id;
	private int product_id;
	private float totalPrice;
//	private int bill_quantity;
//	private List<ProductDTO> products = new ArrayList<>();
	private List<BillProductDTO> billProducts = new ArrayList<>();
	
	public BillDTO() {

	}

	public BillDTO(String bill_no, String customer_id, int product_id, float totalPrice,
			List<BillProductDTO> billProducts) {
		super();
		this.bill_no = bill_no;
		this.customer_id = customer_id;
		this.product_id = product_id;
		this.totalPrice = totalPrice;
		this.billProducts = billProducts;
	}

	public String getBill_no() {
		return bill_no;
	}

	public void setBill_no(String bill_no) {
		this.bill_no = bill_no;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public List<BillProductDTO> getBillProducts() {
		return billProducts;
	}

	public void setBillProducts(List<BillProductDTO> billProducts) {
		this.billProducts = billProducts;
	}

	@Override
	public String toString() {
		return "BillDTO [bill_no=" + bill_no + ", customer_id=" + customer_id + ", product_id=" + product_id
				+ ", totalPrice=" + totalPrice + ", billProducts=" + billProducts + "]";
	}

}
