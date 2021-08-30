package com.online.shopping.product.util;

public class ProductResponseStatus {

	private boolean status;
	private String message;

	public ProductResponseStatus() {
	}

	public ProductResponseStatus(boolean status, String message) {
		this.status = status;
		this.message = message;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
