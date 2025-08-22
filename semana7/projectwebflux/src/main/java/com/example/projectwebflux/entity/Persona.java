package com.example.projectwebflux.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("PERSONAS")
@Getter
@Setter
public class Persona {
    @Id
    private Integer id;

    private String nombre;

    private Integer edad;

    //opcional
//    @MappedCollection(idColumn = "persona_id")
//    private List<Carro> carros;

}
