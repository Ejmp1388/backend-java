package com.javabackend.products.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveNewProductDto {
    private String name;
    private Integer stock;

    public SaveNewProductDto(){
        stock=100;
    }
}
