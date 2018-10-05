package com.service.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {

	private int productId;
	private String productName;
	private int productPrice;
	private int totalQuantity;
	private String mfgDate;
	public Product(int productId, String productName, int productPrice, int totalQuantity, String mfgDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.totalQuantity = totalQuantity;
		this.mfgDate = mfgDate;
	}
	public Product() {
		super();
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public String getMfgDate() {
		return mfgDate;
	}
	public void setMfgDate(String mfgDate) {
		this.mfgDate = mfgDate;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", totalQuantity=" + totalQuantity + ", mfgDate=" + mfgDate + "]";
	}

	
	
}
