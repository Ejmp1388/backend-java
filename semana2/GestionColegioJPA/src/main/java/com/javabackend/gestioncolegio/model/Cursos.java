package com.javabackend.gestioncolegio.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "CURSOS") //si no se coloca eseta anotación toma el nombre de la clase
@Getter
@Setter
public class Cursos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //define como se genera el valor del id
    private Integer id;
    private String nombre;
    //@Column(name = "descripction")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "docent_id")
    private Docente docente;

    @OneToMany(mappedBy = "cursos", fetch = FetchType.EAGER) //define el id de esta clase en la relación u otra tabla
    private List<NotasEstudianteCurso> notasEstudianteCursos;

    @OneToMany(mappedBy = "cursos", fetch = FetchType.EAGER)
    private List<Tareas> tareasPublicadas;
}
