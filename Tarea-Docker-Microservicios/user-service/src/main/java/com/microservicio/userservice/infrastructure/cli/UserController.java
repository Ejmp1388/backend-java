package com.microservicio.userservice.infrastructure.cli;

import com.microservicio.userservice.application.usecase.GetUserByIdUseCase;
import com.microservicio.userservice.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final GetUserByIdUseCase getUserByIdUseCase;

    @GetMapping("/{id}")
    public Mono<User> getUserById(@PathVariable Integer id) {
        return getUserByIdUseCase.buscarporid(id);
    }

    @PostMapping("/save")
    public ResponseEntity<?> createUser(@RequestBody User user){
        getUserByIdUseCase.guardarusuario(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
