package com.microservicio.orquestadorbff.infrastructure.web;

import com.microservicio.orquestadorbff.domain.model.User;
import com.microservicio.orquestadorbff.domain.port.UsuarioClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UsuarioWebClientAdapter implements UsuarioClientPort {

    private final WebClient webClient;

    @Override
    public Mono<User> getUsuarioById(Integer id) {
        return webClient
                .get()
                .uri( "http://user-service:8080/api/v1/user/{id}", id)
                .retrieve()
                .bodyToMono(User.class);
    }
}
