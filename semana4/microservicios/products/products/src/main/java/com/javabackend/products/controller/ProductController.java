package com.javabackend.products.controller;

import com.javabackend.products.dto.SaveNewProductDto;
import com.javabackend.products.dto.UpdateProductDto;
import com.javabackend.products.model.Product;
import com.javabackend.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<?> saveNewProduct(@RequestBody SaveNewProductDto dto){
        Product response= null;
        try {
            response = productService.saveNewProduct(dto.getName(),dto.getStock());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable("name") String name){
        Product response = productService.getProductByName(name);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateStock(@PathVariable("id") String id, @RequestBody UpdateProductDto dto){
        Product response= productService.updateStock(id,dto.getStock());
        return ResponseEntity.ok(response);
    }
}
