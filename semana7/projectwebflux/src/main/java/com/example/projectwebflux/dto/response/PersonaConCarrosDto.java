package com.example.projectwebflux.dto.response;

import com.example.projectwebflux.entity.Carros;
import com.example.projectwebflux.entity.Persona;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonaConCarrosDto {
    private Persona persona;
    private List<Carros> carros;
}
