package com.online.shopping.product.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

import com.online.shopping.product.dto.ProductDTO;
import com.online.shopping.product.service.ProductService;
import com.online.shopping.product.util.DummyData;
import com.online.shopping.product.util.ProductResponseStatus;

@RestController
public class ProductResourceImpl implements ProductResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductResourceImpl.class);

	@Autowired
	Environment environment;

	@Autowired
	ProductService productService;

	@Override
	public String test() {
		String port = environment.getProperty("local.server.port");
		LOGGER.info("ProductService is working on port: {}", port);
		return "ProductService is working on port: " + port;
	}

	@Override
	public ProductDTO getProduct(int productId) {

		LOGGER.info("ProductService: getProduct() execution start");
		LOGGER.info("ProductService: Searching for product: {}", productId);

		return productService.getProduct(productId);
	}
	
	@Override
	public ProductDTO getProductByName(String productName) {
		return productService.getProductByName(productName);
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		return productService.getAllProducts();
	}

	@Override
	public ProductResponseStatus addProduct(ProductDTO productDTO) {
		return productService.addProduct(productDTO);
	}

	@Override
	public ProductResponseStatus updateProduct(int productId, ProductDTO productDTO) {
		return productService.updateProduct(productId, productDTO);
	}

	@Override
	public ProductResponseStatus deleteProduct(int productId) {
		return productService.deleteProduct(productId);
	}
	
	@Override
	public ProductResponseStatus deleteAllProducts() {
		return productService.deleteAllProducts();
	}
	
	@Override
	public List<ProductDTO> getProductsByType(String type) {
		return productService.getProductsByType(type);
	}

	@Override
	public ProductResponseStatus insertDummyData() {
		return productService.saveAll(DummyData.getDummyData());
	}
}
