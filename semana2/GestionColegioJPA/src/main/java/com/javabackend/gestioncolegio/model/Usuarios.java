package com.javabackend.gestioncolegio.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@Entity
@Getter
@Setter
public abstract class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String nombre;
    protected String email;
    @Column(name = "user_type", insertable = false, updatable = false)
    private String tipoUsuario;
}
