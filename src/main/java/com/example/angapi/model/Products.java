package com.example.angapi.model;

import java.math.BigDecimal;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Products {
	
	@Id
	public ObjectId id;

	public String productName;
	public BigDecimal productPrice;

	// Constructors
	public Products() {
	}

	public Products(ObjectId id, String productName, BigDecimal productPrice) {
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	// ObjectId needs to be converted to string
	public String getid() {
		return id.toHexString();
	}

	public void setid(ObjectId id) {
		this.id = id;
	}

	public String getproductName() {
		return productName;
	}

	public void setproductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getproductPrice() {
		return productPrice;
	}

	public void setproductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
}