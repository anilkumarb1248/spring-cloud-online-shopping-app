package com.online.shopping.product.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.online.shopping.product.exceptions.DuplicateProductException;
import com.online.shopping.product.exceptions.ProductNotFoundException;
import com.online.shopping.product.util.ProductResponseStatus;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = ProductNotFoundException.class)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<ProductResponseStatus> handleProductNotFoundException(ProductNotFoundException ex) {

		ProductResponseStatus status = new ProductResponseStatus();
		status.setStatus(false);
		status.setMessage(ex.getMessage());
		return ResponseEntity.ok(status);
	}

	@ExceptionHandler(value = DuplicateProductException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ResponseEntity<ProductResponseStatus> handleDuplicateProductException(DuplicateProductException ex) {

		ProductResponseStatus status = new ProductResponseStatus();
		status.setStatus(false);
		status.setMessage(ex.getMessage());
		return ResponseEntity.ok(status);
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<ProductResponseStatus> handleException(Exception ex) {

		ProductResponseStatus status = new ProductResponseStatus();
		status.setStatus(false);
		status.setMessage("Internale server error occured");
		return ResponseEntity.ok(status);
	}

}
