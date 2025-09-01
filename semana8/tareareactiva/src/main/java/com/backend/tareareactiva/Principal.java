package com.backend.tareareactiva;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class Principal {
    public static void main(String[] args) {

        WebClient cliente = WebClient.create("https://jsonplaceholder.typicode.com");
        Mono<String>response=cliente.get()
                .uri("/posts/1")
                .retrieve()
                .bodyToMono(String.class);

        response.subscribe(
                valor -> System.out.println("onNext: " + valor),   // cuando llega la respuesta
                error -> System.err.println("onError: no encontro recurso " + error), // si ocurre error
                () -> System.out.println("onComplete: flujo terminado") // cuando finaliza
        );
    }
}
