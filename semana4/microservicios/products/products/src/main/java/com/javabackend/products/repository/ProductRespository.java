package com.javabackend.products.repository;

import com.javabackend.products.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRespository extends MongoRepository<Product, String> {
    Product findByName(String name);
}
