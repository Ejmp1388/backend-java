package com.microservicio.orquestadorbff.domain.port;

import com.microservicio.orquestadorbff.domain.model.User;
import reactor.core.publisher.Mono;

public interface UsuarioClientPort {
    Mono<User> getUsuarioById(Integer id);
}
