package com.microservicio.userservice.domain.port;

import com.microservicio.userservice.domain.model.User;
import reactor.core.publisher.Mono;


public interface UserRepositoryPort {
    Mono<User> findById(Integer id);
    void saveUser(User user);
}
