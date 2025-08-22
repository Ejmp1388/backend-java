package com.example.projectwebflux.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Getter
@Setter
public class Carros {

    @Id
    private Integer id;
    private String marca;

    @Column("persona_id")
    private Integer personaId;
}
