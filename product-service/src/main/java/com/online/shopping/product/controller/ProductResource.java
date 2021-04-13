package com.online.shopping.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.online.shopping.product.dto.Product;

@RequestMapping("/product")
public interface ProductResource {

	@GetMapping("/test")
	public String test();

	@GetMapping("/get/{productId}")
	public Product getProduct(@PathVariable("productId") int productId);

}
