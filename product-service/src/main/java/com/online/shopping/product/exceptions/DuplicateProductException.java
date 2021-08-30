package com.online.shopping.product.exceptions;

public class DuplicateProductException extends RuntimeException{

	private static final long serialVersionUID = -4574460910946362732L;

	public DuplicateProductException(String message) {
		super(message);
	}
}
