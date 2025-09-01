package com.microservicio.orquestadorbff.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Perfil {
    private final User usuario;
    private final List<Posts> posts;
}
