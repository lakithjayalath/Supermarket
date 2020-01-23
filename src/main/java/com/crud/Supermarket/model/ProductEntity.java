package com.crud.Supermarket.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "product")
public class ProductEntity implements Serializable{

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int product_id;
	
	@NotBlank
	@Column(name = "product_name")
	private String product_name;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "category")
	private String category;
	
//	@ManyToMany(mappedBy = "products")
//	private List<BillEntity> bills = new ArrayList<>();
	
	@OneToMany(mappedBy = "product", cascade = {CascadeType.ALL})
	private List<BillProductEntity> billProduct = new ArrayList<>();
	
	public ProductEntity() {
	
	}
	
	public ProductEntity(int product_id, @NotBlank String product_name, float price, int quantity, String category) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
	}
	
//	public ProductEntity(int product_id, @NotBlank String product_name, float price, int quantity, String category,
//			List<BillEntity> bills) {
//		super();
//		this.product_id = product_id;
//		this.product_name = product_name;
//		this.price = price;
//		this.quantity = quantity;
//		this.category = category;
//		this.bills = bills;
//	}
	
//	public ProductEntity(int product_id, @NotBlank String product_name, float price, int quantity, String category,
//			List<BillEntity> bills) {
//		super();
//		this.product_id = product_id;
//		this.product_name = product_name;
//		this.price = price;
//		this.quantity = quantity;
//		this.category = category;
//		this.bills = bills;
//	}
	
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

//	public List<BillProductEntity> getBillProduct() {
//		return billProduct;
//	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	
	
//	public void setBillProduct(List<BillProductEntity> billProduct) {
//		this.billProduct = billProduct;
//	}
	
	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public List<BillProductEntity> getBillProduct() {
		return billProduct;
	}

	public void setBillProduct(List<BillProductEntity> billProduct) {
		this.billProduct = billProduct;
	}

	@Override
	public String toString() {
		return "ProductEntity [product_id=" + product_id + ", product_name=" + product_name + ", price=" + price
				+ ", quantity=" + quantity + ", category=" + category + ", billProduct=" + billProduct + "]";
	}
	
}
