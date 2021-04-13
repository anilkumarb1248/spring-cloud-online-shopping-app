package com.online.shopping.search.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.online.shopping.search.dto.Product;

@RequestMapping("/search")
public interface SearchResource {
	
	@GetMapping("/test")
	public String test();
	
	@GetMapping("/search-product/{productId}")
	public Product searchProduct(@PathVariable("productId") int productId);

}
