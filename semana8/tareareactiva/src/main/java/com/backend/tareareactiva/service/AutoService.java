package com.backend.tareareactiva.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import com.backend.tareareactiva.model.Auto;
import com.backend.tareareactiva.repository.AutoRepository;

@Service
public class AutoService {
    private final AutoRepository autoRepository;

    public AutoService(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    public Mono<Auto> findById(Integer id) {
        return autoRepository.findById(id);
    }
}
