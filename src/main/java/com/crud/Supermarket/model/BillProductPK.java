package com.crud.Supermarket.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BillProductPK implements Serializable{

	private String billno;

	private int productid;
	
	public BillProductPK() {
		
	}

	public BillProductPK(String billno, int productid) {
		super();
		this.billno = billno;
		this.productid = productid;
	}

	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	@Override
	public String toString() {
		return "BillProductPK [billno=" + billno + ", productid=" + productid + "]";
	}

}
