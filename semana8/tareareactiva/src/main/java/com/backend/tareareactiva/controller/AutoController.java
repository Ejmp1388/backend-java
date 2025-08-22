package com.backend.tareareactiva.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import com.backend.tareareactiva.model.Auto;
import com.backend.tareareactiva.service.AutoService;

@RestController
@RequestMapping("/api/v1/autos")
@RequiredArgsConstructor
public class AutoController {
    public final AutoService autoService;

    @GetMapping("/{id}")
    public Mono<Auto> getAutoById(@PathVariable Integer id) {
        return autoService.findById(id);
    }


}
