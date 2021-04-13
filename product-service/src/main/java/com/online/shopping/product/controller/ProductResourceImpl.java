package com.online.shopping.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.online.shopping.product.dto.Product;

@RestController
public class ProductResourceImpl implements ProductResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductResourceImpl.class);

	@Autowired
	Environment environment;

	@Override
	public String test() {
		String port = environment.getProperty("local.server.port");
		LOGGER.info("SearchService is working on port: {}", port);
		return "SearchService is working on port: " + port;
	}

	@Override
	public Product getProduct(int productId) {

		LOGGER.info("ProductService: getProduct() execution start");
		LOGGER.info("ProductService: Searching for product: {}", productId);

		Product product = new Product();
		product.setProductId(productId);
		product.setProductName("Car");
		product.setType("Vehicle");

		if (LOGGER.isDebugEnabled()) {
			try {
				LOGGER.debug("Found the product with id: {} {}", productId,
						new ObjectMapper().writeValueAsString(product));
			} catch (JsonProcessingException e) {
				LOGGER.debug("Exception occured while processing the data: {}", e.getMessage());
			}
		}

		LOGGER.info("ProductService: getProduct() execution end");
		return product;
	}

}
