package com.javabackend.gestioncolegio.dto;

import com.javabackend.gestioncolegio.model.Cursos;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TareasResponseDto {
    private Integer id;
    private String titulo;
    private String descripcion;
    private LocalDate fechaPublicacion;


}
