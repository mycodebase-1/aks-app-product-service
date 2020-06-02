package com.abhi.productservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	
}
