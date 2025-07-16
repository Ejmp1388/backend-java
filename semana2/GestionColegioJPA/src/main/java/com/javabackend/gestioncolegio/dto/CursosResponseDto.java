package com.javabackend.gestioncolegio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursosResponseDto {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String docent_id;
    private TareasResponseDto tareasResponseDto;
}
