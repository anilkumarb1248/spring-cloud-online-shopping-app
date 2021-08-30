package com.online.shopping.product.exceptions;

public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8557274237373424382L;

	public ProductNotFoundException(String message) {
		super(message);
	}
}
