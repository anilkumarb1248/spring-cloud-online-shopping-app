package com.online.shopping.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.shopping.product.entity.Product;
import com.online.shopping.product.enums.ProductType;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	public Optional<Product> findByProductName(String productName);

	public List<Product> findAllByType(ProductType type);
}
