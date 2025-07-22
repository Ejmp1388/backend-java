package com.javabackend.products.service;

import com.javabackend.products.model.Product;
import com.javabackend.products.repository.ProductRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRespository productRespository;

    public Product saveNewProduct(String name) {
        Product product = new Product();
        product.setStock(100);
        product.setName(name);

        return productRespository.save(product);
    }

    public Product getProductByName(String name){
        return productRespository.findByName(name);
    }

    public Product updateStock(String id, Integer quantitySold){
        Product product=productRespository.findById(id).get();
        product.setStock(product.getStock() -quantitySold);
        return productRespository.save(product);
    }
}
