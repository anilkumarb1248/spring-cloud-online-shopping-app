package com.online.shopping.search.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.online.shopping.search.dto.ProductDTO;

@RequestMapping("/search")
public interface SearchResource {
	
	@GetMapping("/test")
	public String test();
	
	@GetMapping("/searchProdcut/{id}")
	public ProductDTO searchProduct(@PathVariable("id") int productId);
	
	@GetMapping("/searchProdcutByName")
	public ProductDTO searchProductByName(@RequestParam("name") String productName);
	
	@GetMapping("/searchProductsByType")
	public List<ProductDTO> searchProductsByType(@RequestParam("type") String type);

}
