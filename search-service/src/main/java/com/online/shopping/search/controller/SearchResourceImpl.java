package com.online.shopping.search.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.online.shopping.search.dto.Product;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class SearchResourceImpl implements SearchResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(SearchResourceImpl.class);

	@Autowired
	Environment environment;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public String test() {
		String port = environment.getProperty("local.server.port");
//		String port = environment.getProperty("server.port");
		LOGGER.info("SearchService is working on port: {}", port);
		return "SearchService is working on port: " + port;
	}

	@Override
	@CircuitBreaker(name = "SearchProductResilenceConfig", fallbackMethod = "alternativeMethod")
	public Product searchProduct(int productId) {

		LOGGER.info("SearchService: searchProduct() execution start");
		LOGGER.info("SearchService: Sending the request to ProductService widh product id: {}", productId);

		Product product = restTemplate.getForObject("http://ProductService/ProductService/product/get/" + productId,
				Product.class);

		if (LOGGER.isDebugEnabled()) {
			try {
				LOGGER.debug("Got the response form ProductService: {}",
						new ObjectMapper().writeValueAsString(product));
			} catch (JsonProcessingException e) {
				LOGGER.debug("Exception occured while processing the data: {}", e.getMessage());
			}
		}

		LOGGER.info("SearchService: searchProduct() execution end");
		return product;

	}

	public Product alternativeMethod(Exception e) {
		Product dummyProduct = new Product();
//		dummyProduct.setProductId(0);
//		dummyProduct.setProductName("Dummy");
//		dummyProduct.setType("Dummy");

		return dummyProduct;
	}

}
