package com.example.projectwebflux.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Integer> test(){
        return Flux.just(1,2,3,4,5).delayElements(Duration.ofSeconds(1));
    }

    @PostMapping(value = "/flux-input", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Integer> textInputFlux(@RequestBody Flux<Integer> emitidorNumeros){
        return emitidorNumeros.map(n->n*2);
    }

    @GetMapping(value = "/holaword", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<String> message(){
        return Mono.just("hola mundo");
    }


}
