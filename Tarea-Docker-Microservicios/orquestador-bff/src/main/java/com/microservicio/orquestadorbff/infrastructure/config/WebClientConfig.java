package com.microservicio.orquestadorbff.infrastructure.config;


import com.microservicio.orquestadorbff.application.usecase.GetPerfilCompletoUseCase;
import com.microservicio.orquestadorbff.domain.port.PostClientPort;
import com.microservicio.orquestadorbff.domain.port.UsuarioClientPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }

    // beans para casos de uso e inyección (puedes usar @Component en adaptadores y constructor injection en el usecase)
    @Bean
    public GetPerfilCompletoUseCase getPerfilCompletoUseCase(UsuarioClientPort usuarioClient, PostClientPort postClient) {
        return new GetPerfilCompletoUseCase(usuarioClient, postClient);
    }
}
