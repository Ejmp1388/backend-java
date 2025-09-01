package com.microservicio.orquestadorbff.infrastructure.dto;

import com.microservicio.orquestadorbff.domain.model.Posts;
import com.microservicio.orquestadorbff.domain.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PerfilCompletoDTO {
    private User usuario;
    private List<Posts> posts;
}
