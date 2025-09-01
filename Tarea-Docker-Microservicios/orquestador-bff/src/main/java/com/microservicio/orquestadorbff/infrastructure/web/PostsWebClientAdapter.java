package com.microservicio.orquestadorbff.infrastructure.web;

import com.microservicio.orquestadorbff.domain.model.Posts;
import com.microservicio.orquestadorbff.domain.port.PostClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class PostsWebClientAdapter implements PostClientPort {

    private final WebClient webClient;

    @Override
    public Flux<Posts> getPostsByUserId(Integer userId) {
        return webClient
                .get()
                .uri( "http://posts-users:8090/api/v1/posts/{userId}", userId)
                .retrieve()
                .bodyToFlux(Posts.class);
    }
}