package com.online.shopping.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.online.shopping.product.service.ProductService;
import com.online.shopping.product.util.DummyData;

@SpringBootApplication
@EnableEurekaClient
public class ProductServiceApplication implements CommandLineRunner {

	@Autowired
	ProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productService.saveAll(DummyData.getDummyData());
	}
}
