package com.javabackend.products.service;

import com.javabackend.products.model.Product;
import com.javabackend.products.repository.ProductRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRespository productRespository;

    public Product saveNewProduct(String name, Integer stock) throws Exception {
        Product product = new Product();
        product.setStock(stock);
        product.setName(name);

        Product products = productRespository.findByName(name);
        if(products !=null){
            throw new Exception("Ya existe producto");

        }
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
