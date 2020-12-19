package com.lti.pojo;

//import java.time.LocalDate;

import com.lti.entity.Product;

public class Order {
	private int id;
	private int quantity;
	private Product productid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product getProductid() {
		return productid;
	}
	public void setProductid(Product productid) {
		this.productid = productid;
	}

	
}
