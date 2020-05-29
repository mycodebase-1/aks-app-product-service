package com.abhi.productservice;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.util.Assert;

import com.azure.data.cosmos.CosmosClient;
import com.azure.data.cosmos.CosmosContainer;
import com.azure.data.cosmos.CosmosDatabase;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class ProductApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@Autowired
	ProductRepo productRepo;
	
	private CosmosClient client;
	private CosmosDatabase database;
    private CosmosContainer container;

	private final String databaseName = "product-service";
    private final String containerName = "product-service";

    public void close() {
        client.close();
    }
    
    
	

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		final Products product1 = new Products(1, "iPhoneXS", "Apple", "Smart Phone");
		final Products product2 = new Products(2, "iPhoneXR", "Apple", "Mobile Phones");
		final Products product3 = new Products(3, "Galaxy S10", "Samsung", "Mobile Phones");
		final Products product4 = new Products(4, "Latitude", "Dell", "Laptop");

		LOGGER.info("Loading products to cosmos db");
		productRepo.save(product1).block();
		productRepo.save(product2).block();
		productRepo.save(product3).block();
		productRepo.save(product4).block();
		
		
		
		LOGGER.info("Saved products");

		final Optional<Products> optionalUserResult = productRepo.findById(1).blockOptional();
		Assert.isTrue(optionalUserResult.isPresent(), "Cannot find user.");

		final Products result = optionalUserResult.get();

		Assert.state(result.getProductCompany().equals("Apple"), "query result firstName doesn't match!");

		LOGGER.info("Found user by findById : {}", result.getProductName());

	}

}
