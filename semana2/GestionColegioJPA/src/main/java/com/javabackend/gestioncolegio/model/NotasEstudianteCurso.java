package com.javabackend.gestioncolegio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class NotasEstudianteCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double notas;
    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiantes;

    @ManyToOne
    @JoinColumn(name = "cursos_id")
    private Cursos cursos;
}
