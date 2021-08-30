package com.online.shopping.search.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.online.shopping.search.dto.ProductDTO;

@FeignClient(value = "ProductService", path = "/ProductService/product", fallback = ProductFeignFallBack.class)
public interface SearchProductFeignClient {

	@GetMapping("/test")
	public String test();

	@GetMapping("/get")
	public ProductDTO getProduct(@RequestParam("id") int productId);

	@GetMapping("/getByName")
	public ProductDTO getProductByName(@RequestParam("name") String productName);

	@GetMapping("/getProductsByType")
	public List<ProductDTO> getProductsByType(@RequestParam("type") String type);

}
