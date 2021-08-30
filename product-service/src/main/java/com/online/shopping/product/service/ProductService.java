package com.online.shopping.product.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.online.shopping.product.dto.ProductDTO;
import com.online.shopping.product.util.ProductResponseStatus;

public interface ProductService {

	public List<ProductDTO> getAllProducts();

	public ProductResponseStatus addProduct(ProductDTO productDTO);

	public ProductDTO getProduct(int productId);

	public ProductResponseStatus updateProduct(int productId, @RequestBody ProductDTO productDTO);

	public ProductResponseStatus deleteProduct(int productId);

	public ProductResponseStatus saveAll(List<ProductDTO> productDTOList);

	public ProductDTO getProductByName(String productName);

	public List<ProductDTO> getProductsByType(String type);

	public ProductResponseStatus deleteAllProducts();
}
