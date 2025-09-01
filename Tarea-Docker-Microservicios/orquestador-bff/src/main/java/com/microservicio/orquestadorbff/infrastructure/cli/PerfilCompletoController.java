package com.microservicio.orquestadorbff.infrastructure.cli;

import com.microservicio.orquestadorbff.application.usecase.GetPerfilCompletoUseCase;
import com.microservicio.orquestadorbff.infrastructure.dto.PerfilCompletoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/perfilcompleto")
@RequiredArgsConstructor
public class PerfilCompletoController {
    private final GetPerfilCompletoUseCase useCase;

    @GetMapping(value = "/{idUsuario}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<PerfilCompletoDTO> getPerfilCompleto(@PathVariable Integer idUsuario) {
        return useCase.execute(idUsuario)
                .map(perfil -> new PerfilCompletoDTO(perfil.getUsuario(), perfil.getPosts()));
    }

}
