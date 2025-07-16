package com.javabackend.gestioncolegio.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@DiscriminatorValue("ESTUDIANTE")
@Getter
@Setter
public class Estudiante extends Usuarios{
    @OneToMany(mappedBy = "estudiantes")
    private List<NotasEstudianteCurso> notasEstudianteCursos;
}
