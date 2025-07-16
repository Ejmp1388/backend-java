package com.javabackend.gestioncolegio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "TAREAS")
@Getter
@Setter
public class Tareas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String descripcion;
    private LocalDate fechaPublicacion;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Cursos cursos;
}
