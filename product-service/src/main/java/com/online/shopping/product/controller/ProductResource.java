package com.online.shopping.product.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.online.shopping.product.dto.ProductDTO;
import com.online.shopping.product.util.ProductResponseStatus;

@RequestMapping("/product")
public interface ProductResource {

	@GetMapping("/test")
	public String test();

	@GetMapping("/all")
	public List<ProductDTO> getAllProducts();

	@PostMapping("/add")
	public ProductResponseStatus addProduct(@RequestBody ProductDTO productDTO);

	@GetMapping("/get")
	public ProductDTO getProduct(@RequestParam("id") int productId);

	@GetMapping("/getByName")
	public ProductDTO getProductByName(@RequestParam("name") String productName);

	@PutMapping("/update/{id}")
	public ProductResponseStatus updateProduct(@PathVariable("id") int productId, @RequestBody ProductDTO productDTO);

	@DeleteMapping("/delete")
	public ProductResponseStatus deleteProduct(@RequestParam("id") int productId);

	@DeleteMapping("/deleteAll")
	public ProductResponseStatus deleteAllProducts();
	
	@GetMapping("/getProductsByType")
	public List<ProductDTO> getProductsByType(@RequestParam("type") String type);

	@PostMapping("/dummyData")
	public ProductResponseStatus insertDummyData();
}
