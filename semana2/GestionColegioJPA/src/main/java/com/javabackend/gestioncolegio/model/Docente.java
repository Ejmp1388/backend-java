package com.javabackend.gestioncolegio.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@DiscriminatorValue("DOCENTE")
@Getter
@Setter
public class Docente extends Usuarios {
    @OneToMany(mappedBy = "docente")
    private List<Cursos> cursos;
}
