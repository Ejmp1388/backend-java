package com.microservicio.orquestadorbff.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Posts {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;
}
