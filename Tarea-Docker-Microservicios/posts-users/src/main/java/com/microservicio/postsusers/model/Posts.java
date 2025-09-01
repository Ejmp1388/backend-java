package com.microservicio.postsusers.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
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
