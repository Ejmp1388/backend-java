package com.example.projectwebflux.repository;

import com.example.projectwebflux.entity.Carros;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface CarroRepository extends ReactiveCrudRepository<Carros,Integer> {

    Flux<Carros> findByPersonaId(Integer personaId);
}
