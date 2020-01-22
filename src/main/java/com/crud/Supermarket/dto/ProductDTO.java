package com.crud.Supermarket.dto;

public class ProductDTO {

	private int product_id;
	private String productname;
	private float price;
	private int quantity;
	private String category;
	
	public ProductDTO() {
		
	}

	public ProductDTO(int product_id, String productname, float price, int quantity, String category) {
		this.product_id = product_id;
		this.productname = productname;
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

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
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
		return "ProductDTO [product_id=" + product_id + ", productname=" + productname + ", price=" + price
				+ ", quantity=" + quantity + ", category=" + category + "]";
	}
	
}
