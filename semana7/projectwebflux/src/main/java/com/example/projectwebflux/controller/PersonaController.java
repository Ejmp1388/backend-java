package com.example.projectwebflux.controller;

import com.example.projectwebflux.dto.response.PersonaConCarrosDto;
import com.example.projectwebflux.entity.Persona;
import com.example.projectwebflux.repository.PersonaRepository;
import com.example.projectwebflux.service.PersonaService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persona")
@RequiredArgsConstructor
public class PersonaController {

    public final PersonaService personaService;

    @PostMapping
    public Mono<Persona> savePersona(@RequestBody Persona persona){
        return personaService.savePersona(persona);
    }

    @GetMapping("/edad/{edad}")
    public Flux<Persona> getPersonaByEdad(@PathVariable("edad") Integer edad){
        return personaService.getPersonByEdad(Mono.just(edad));
    }

    @PostMapping(value = "/buscar")
    public Flux<Persona> buscarPersonas(@RequestBody List<String> nombres) {
        // por cada nombre recibido, buscará en DB y devolverá los resultados concatenados
        return Flux.fromIterable(nombres).flatMap(personaService::getPersonasByNames);
    }

    @GetMapping("/personaCarro/{id}")
    public Mono<PersonaConCarrosDto> buscarPersonaCarros(@PathVariable("id") Integer id){
        return personaService.getPersonaConCarros(id);
    }






}
