package com.example.projectwebflux.service;

import com.example.projectwebflux.dto.response.PersonaConCarrosDto;
import com.example.projectwebflux.entity.Carros;
import com.example.projectwebflux.entity.Persona;
import com.example.projectwebflux.repository.CarroRepository;
import com.example.projectwebflux.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaService {

    private final PersonaRepository personaRepository;
    private final CarroRepository carroRepository;

    public Mono<Persona> savePersona(Persona persona){
        return personaRepository.save(persona);
    }

    public Flux<Persona> getPersonByEdad(Mono<Integer> emisorEdad){
        return personaRepository.findByEdad(emisorEdad);
    }

    public Flux<Persona> getPersonasByNames(String emisorNombre){
        return personaRepository.findByNombre(emisorNombre);

    }

    /*public Mono<PersonaConCarrosDto> getPersonaConCarros(Integer personaId){
        return personaRepository.findById(personaId) //mono de <persona>
                //mono<persona> convertir a --> mono<personaconcarrodto>
                .flatMap(
                        persona -> {
                    Flux<Carros> carroFlux=carroRepository.findByPersonaId(persona.getId()); //Obtengo los carros
                    Mono<List<Carros>> monoCarroList=carroFlux.collectList();//este flux de carro lo convierto en una lista, porque no puede estar no puedo hacer procesos bloqueantes
                    return monoCarroList.flatMap(carroList ->//tomar mono<list<carro>> y devolver mono<personaconcarrosdto>
                            Mono.just(mapPersonaCarros(persona,carroList)));

                });
    }*/

   /* public Mono<PersonaConCarrosDto> getPersonaConCarros(Integer personaId){
        return personaRepository.findById(personaId) //mono de <persona>
                .flatMap(persona -> {
                            Flux<Carro> carroFlux=carroRepository.findByPersonaId(persona.getId()); //Obtengo los carros
                            return Mono.just(mapPersonaCarros(persona,carroFlux));

                        });
    }*/


    public Mono<PersonaConCarrosDto> getPersonaConCarros(Integer personaId){
        return personaRepository.findById(personaId)
                .flatMap(persona -> carroRepository.findByPersonaId(persona.getId())
                        .collectList() // ← Convertimos Flux<Carro> en Mono<List<Carro>>
                        .map(carros -> mapPersonaCarros(persona, carros))
                );
    }

    private PersonaConCarrosDto mapPersonaCarros(Persona persona,List<Carros> carroList){
        PersonaConCarrosDto dto=new PersonaConCarrosDto();
        dto.setCarros(carroList);
        dto.setPersona(persona);
        return dto;
    }


}
