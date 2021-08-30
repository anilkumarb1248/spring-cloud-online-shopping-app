package com.online.shopping.search.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.online.shopping.search.dto.ProductDTO;
import com.online.shopping.search.feign.client.SearchProductFeignClient;

@RestController
public class SearchResourceImpl implements SearchResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(SearchResourceImpl.class);

	@Autowired
	Environment environment;

	@Autowired
	SearchProductFeignClient productFeignClient;

	@Override
	public String test() {
		String port = environment.getProperty("local.server.port");
//		String port = environment.getProperty("server.port");
		LOGGER.info("SearchService is working on port: {}", port);

		String productServiceResponse = productFeignClient.test();

		return "SearchService is working on port: " + port + " " + productServiceResponse;
	}

	@Override
//	@CircuitBreaker(name = "SearchProductResilenceConfig", fallbackMethod = "alternativeMethod")
	public ProductDTO searchProduct(int productId) {

		LOGGER.info("SearchService: searchProduct() execution start");
		LOGGER.info("SearchService: Sending the request to ProductService widh product id: {}", productId);

		// Product product =
		// restTemplate.getForObject("http://ProductService/ProductService/product/get/"
		// + productId, Product.class);

		ProductDTO productDTO = productFeignClient.getProduct(productId);

		if (LOGGER.isDebugEnabled()) {
			try {
				LOGGER.debug("Got the response form ProductService: {}",
						new ObjectMapper().writeValueAsString(productDTO));
			} catch (JsonProcessingException e) {
				LOGGER.debug("Exception occured while processing the data: {}", e.getMessage());
			}
		}

		LOGGER.info("SearchService: searchProduct() execution end");
		return productDTO;

	}

//	public ProductDTO alternativeMethod(Exception e) {
//		return new ProductDTO();
//	}

	@Override
	public ProductDTO searchProductByName(String productName) {
		LOGGER.info("SearchService: searchProductByName() execution start");
		LOGGER.info("SearchService: Sending the request to ProductService widh productName: {}", productName);

		ProductDTO productDTO = productFeignClient.getProductByName(productName);

		LOGGER.info("SearchService: searchProduct() execution end");
		return productDTO;

	}

	@Override
	public List<ProductDTO> searchProductsByType(String type) {
		LOGGER.info("SearchService: searchByProductType() execution start");
		LOGGER.info("SearchService: Sending the request to ProductService widh product type: {}", type);

		List<ProductDTO> productsList = productFeignClient.getProductsByType(type);

		if (LOGGER.isDebugEnabled()) {
			try {
				LOGGER.debug("Got the response form ProductService: {}",
						new ObjectMapper().writeValueAsString(productsList));
			} catch (JsonProcessingException e) {
				LOGGER.debug("Exception occured while processing the data: {}", e.getMessage());
			}
		}

		LOGGER.info("SearchService: searchByProductType() execution end");
		return productsList;
	}

}
