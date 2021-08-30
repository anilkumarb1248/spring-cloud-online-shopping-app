package com.online.shopping.search.feign.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.online.shopping.search.dto.ProductDTO;

@Component
public class ProductFeignFallBack implements SearchProductFeignClient {

	@Override
	public String test() {
		return "ProductFeignFallBack called";
	}

	@Override
	public ProductDTO getProduct(int productId) {
		return new ProductDTO();
	}

	@Override
	public ProductDTO getProductByName(String productName) {
		return new ProductDTO();
	}

	@Override
	public List<ProductDTO> getProductsByType(String type) {
		return new ArrayList<>();
	}

}
