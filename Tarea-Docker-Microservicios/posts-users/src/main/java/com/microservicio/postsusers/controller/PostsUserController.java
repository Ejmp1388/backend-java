package com.microservicio.postsusers.controller;

import com.microservicio.postsusers.model.Posts;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/posts")
public class PostsUserController {

    @GetMapping(value = "/{id}", produces = "application/json")
    public Flux<Posts> getPostUsers(@PathVariable Integer id){
        WebClient client = WebClient.create("https://jsonplaceholder.typicode.com");
        Flux<Posts> response = client.get()
                .uri("/posts?userId="+id) // recurso dummy
                .retrieve()
                .bodyToFlux(Posts.class);

        // Suscripción al Mono
        response.subscribe(
                valor -> System.out.println("onNext: completado"),   // cuando llega la respuesta
                error -> System.err.println("onError: " + error), // si ocurre error
                () -> System.out.println("onComplete: flujo terminado") // cuando finaliza
        );

        return response;
    }


}
