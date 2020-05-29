package com.abhi.productservice;

import org.springframework.stereotype.Repository;

import com.microsoft.azure.spring.data.cosmosdb.repository.ReactiveCosmosRepository;

import reactor.core.publisher.Flux;

@Repository
public interface ProductRepo extends ReactiveCosmosRepository<Products, Integer> {
    //Products findByProductId(Integer id);
    Flux<Products> findByProductId(Integer productId);
    //Flux<Products> findAll();
}