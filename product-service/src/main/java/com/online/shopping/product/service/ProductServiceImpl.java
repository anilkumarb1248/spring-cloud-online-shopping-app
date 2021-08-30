package com.online.shopping.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.shopping.product.dto.ProductDTO;
import com.online.shopping.product.entity.Product;
import com.online.shopping.product.enums.ProductType;
import com.online.shopping.product.exceptions.DuplicateProductException;
import com.online.shopping.product.exceptions.ProductNotFoundException;
import com.online.shopping.product.repository.ProductRepository;
import com.online.shopping.product.util.ProductResponseStatus;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<ProductDTO> getAllProducts() {
		List<Product> productsList = productRepository.findAll();
		return productsList.stream().map(entity -> {
			ProductDTO dto = new ProductDTO();
			BeanUtils.copyProperties(entity, dto);
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public ProductResponseStatus addProduct(ProductDTO productDTO) {
		if (productRepository.findByProductName(productDTO.getProductName()).isPresent()) {
			throw new DuplicateProductException("Product already exist with name: " + productDTO.getProductName());
		}

		Product product = new Product();
		BeanUtils.copyProperties(productDTO, product);
		Product newProduct = productRepository.save(product);
		return new ProductResponseStatus(true, "Product Added with id: " + newProduct.getProductId());
	}

	@Override
	public ProductDTO getProduct(int productId) {

		Optional<Product> optional = productRepository.findById(productId);
		if (optional.isPresent()) {
			Product product = optional.get();
			ProductDTO productDTO = new ProductDTO();

			BeanUtils.copyProperties(product, productDTO);
			return productDTO;
		} else {
			throw new ProductNotFoundException("Product not found with id: " + productId);
		}
	}

	@Override
	public ProductDTO getProductByName(String productName) {
		Optional<Product> optional = productRepository.findByProductName(productName);
		if (optional.isPresent()) {
			Product product = optional.get();
			ProductDTO productDTO = new ProductDTO();

			BeanUtils.copyProperties(product, productDTO);
			return productDTO;
		} else {
			throw new ProductNotFoundException("Product not found with name: " + productName);
		}
	}

	@Override
	public ProductResponseStatus updateProduct(int productId, ProductDTO productDTO) {

		Optional<Product> optional = productRepository.findById(productId);
		if (optional.isPresent()) {
			Product product = optional.get();
			BeanUtils.copyProperties(productDTO, product);
			product.setProductId(productId);
			productRepository.save(product);
		} else {
			throw new ProductNotFoundException("Product not found with id: " + productId);
		}

		return new ProductResponseStatus(true, "Product updated successfully");
	}

	@Override
	public ProductResponseStatus deleteProduct(int productId) {
		if (productRepository.findById(productId).isPresent()) {
			productRepository.deleteById(productId);
			return new ProductResponseStatus(true, "Product deleted successfully");
		} else {
			throw new ProductNotFoundException("Product not found with id: " + productId);
		}
	}

	@Override
	public ProductResponseStatus deleteAllProducts() {
		productRepository.deleteAll();
		return new ProductResponseStatus(true, "Products deleted successfully");
	}

	@Override
	public ProductResponseStatus saveAll(List<ProductDTO> productDTOList) {
		List<Product> newProductList = new ArrayList<>();
		productDTOList.forEach(productDTO -> {
			if (!productRepository.findByProductName(productDTO.getProductName()).isPresent()) {
				Product newProduct = new Product();
				BeanUtils.copyProperties(productDTO, newProduct);
				newProductList.add(newProduct);
			}
		});
		productRepository.saveAll(newProductList);
		return new ProductResponseStatus(true, "Products added successfully");
	}

	@Override
	public List<ProductDTO> getProductsByType(String type) {
		List<Product> productsList = productRepository.findAllByType(ProductType.valueOf(type.toUpperCase()));
		return productsList.stream().map(entity -> {
			ProductDTO dto = new ProductDTO();
			BeanUtils.copyProperties(entity, dto);
			return dto;
		}).collect(Collectors.toList());
	}

}
