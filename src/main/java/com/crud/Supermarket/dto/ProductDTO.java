package com.crud.Supermarket.dto;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {

	private int product_id;
	private String product_name;
	private float price;
	private int quantity;
	private String category;
//	private List<BillDTO> bill = new ArrayList<>();
	
	public ProductDTO() {
		
	}

	public ProductDTO(int product_id, String product_name, float price, int quantity, String category) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}
	
	public int getProduct_id() {
		return product_id;
	}


	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ProductDTO [product_id=" + product_id + ", product_name=" + product_name + ", price=" + price
				+ ", quantity=" + quantity + ", category=" + category + "]";
	}

}
