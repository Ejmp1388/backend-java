package com.microservicio.userservice.application.usecase;

import com.microservicio.userservice.domain.model.User;
import com.microservicio.userservice.domain.port.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
public class GetUserByIdUseCase {
    private final UserRepositoryPort repositoryport;

    public Mono<User> buscarporid(Integer id) {
        return repositoryport.findById(id);
    }

    public void guardarusuario(User user){
        repositoryport.saveUser(user);
    }


}
