package com.example.projectwebflux.repository;

import com.example.projectwebflux.entity.Persona;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonaRepository extends ReactiveCrudRepository<Persona,Integer> {
    //el mono no tiene mucho sentido pero se puede hacer
    Flux<Persona> findByEdad(Mono<Integer> edad);
    Flux<Persona> findByNombre(String nombre);

}
