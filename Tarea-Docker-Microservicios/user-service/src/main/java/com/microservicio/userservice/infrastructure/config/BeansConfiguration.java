package com.microservicio.userservice.infrastructure.config;

import com.microservicio.userservice.application.usecase.GetUserByIdUseCase;
import com.microservicio.userservice.domain.port.UserRepositoryPort;
import com.microservicio.userservice.infrastructure.mongo.UserRepositoryAdapter;
import com.microservicio.userservice.infrastructure.mongo.repository.UserMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeansConfiguration {


    @Bean
    public GetUserByIdUseCase getUserByIdUseCase(UserRepositoryPort port) {
        return new GetUserByIdUseCase(port);
    }
}
