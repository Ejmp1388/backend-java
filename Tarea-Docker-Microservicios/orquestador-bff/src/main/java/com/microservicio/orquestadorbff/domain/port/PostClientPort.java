package com.microservicio.orquestadorbff.domain.port;

import com.microservicio.orquestadorbff.domain.model.Posts;
import reactor.core.publisher.Flux;

public interface PostClientPort {
    Flux<Posts> getPostsByUserId(Integer userId);
}
