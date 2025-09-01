package com.backend.usuariosmicro.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class HolaMundoController {

    @GetMapping("/hola")
    public Mono<String> holaMundo() {

        WebClient client = WebClient.create("https://jsonplaceholder.typicode.com");

        // Llamada REST que devuelve un Mono<String>
        Mono<String> response = client.get()
                .uri("/posts/1") // recurso dummy
                .retrieve()
                .bodyToMono(String.class);

        // Suscripción al Mono
        response.subscribe(
                valor -> System.out.println("onNext: " + valor),   // cuando llega la respuesta
                error -> System.err.println("onError: " + error), // si ocurre error
                () -> System.out.println("onComplete: flujo terminado") // cuando finaliza

        );

        // ⚠️ Como es un flujo reactivo asíncrono, damos un pequeño sleep
        try { Thread.sleep(3000); } catch (InterruptedException e) { }
        return response;
    }

}