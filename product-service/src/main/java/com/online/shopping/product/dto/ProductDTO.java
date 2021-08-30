package com.online.shopping.product.dto;

import java.io.Serializable;

import com.online.shopping.product.enums.ProductType;

public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int productId;
	private String productName;
	private ProductType type;

	public ProductDTO() {
		super();
	}

	public ProductDTO(int productId, String productName, ProductType type) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.type = type;
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

	public ProductType getType() {
		return type;
	}

	public void setType(ProductType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", type=" + type + "]";
	}

}
