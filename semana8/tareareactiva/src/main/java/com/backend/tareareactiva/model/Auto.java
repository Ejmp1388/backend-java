package com.backend.tareareactiva.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "auto")
@Getter
@Setter
@AllArgsConstructor
public class Auto {
    @Id
    private Integer id;
    private String marca;
    private String modelo;
    private Integer anio;
}
