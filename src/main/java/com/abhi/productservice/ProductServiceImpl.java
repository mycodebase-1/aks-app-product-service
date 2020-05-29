package com.abhi.productservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Override
	public Products getProduct(Integer productId) {
		final Optional<Products> optionalUserResult = productRepo.findById(productId).blockOptional();
		
		final Products product = optionalUserResult.get();
		return product;
	}

	@Override
	public List<Products> getAllProducts() {
		List<Products> products = (List<Products>) productRepo.findAll();
		return products;
	}
}