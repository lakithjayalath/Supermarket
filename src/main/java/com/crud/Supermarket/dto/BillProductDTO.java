package com.crud.Supermarket.dto;

public class BillProductDTO {

	private String bill_no;
	private int product_id;
	private int quantity;
	
	public BillProductDTO() {
		
	}

	public BillProductDTO(String bill_no, int product_id, int quantity) {
		super();
		this.bill_no = bill_no;
		this.product_id = product_id;
		this.quantity = quantity;
	}

	public String getBill_no() {
		return bill_no;
	}

	public void setBill_no(String bill_no) {
		this.bill_no = bill_no;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "BillProductDTO [bill_no=" + bill_no + ", product_id=" + product_id + ", quantity=" + quantity + "]";
	}

}
