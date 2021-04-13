package com.online.shopping.search.dto;

import java.io.Serializable;

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	private int productId;
	private String productName;
	private String type;

	public Product() {
		super();
	}

	public Product(int productId, String productName, String type) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.type = type;
	}

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", type=" + type + "]";
	}

}
