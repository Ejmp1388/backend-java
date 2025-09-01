package com.microservicio.orquestadorbff.application.usecase;

import com.microservicio.orquestadorbff.domain.model.Perfil;
import com.microservicio.orquestadorbff.domain.model.Posts;
import com.microservicio.orquestadorbff.domain.model.User;
import com.microservicio.orquestadorbff.domain.port.PostClientPort;
import com.microservicio.orquestadorbff.domain.port.UsuarioClientPort;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class GetPerfilCompletoUseCase {
    private final UsuarioClientPort usuarioClient;
    private final PostClientPort postClient;



    /**
     * Retorna Mono<Tuple2<Usuario, List<Post>>> o en este caso
     * aprovechamos zipWith: Mono<Usuario>.zipWith(posts.collectList(), (u, posts) -> new Perfil(u, posts))
     */
    public Mono<Perfil> execute(Integer userId) {
        Mono<User> usuarioMono = usuarioClient.getUsuarioById(userId);
        Mono<List<Posts>> postsListMono = postClient.getPostsByUserId(userId).collectList();

        return usuarioMono.zipWith(postsListMono, (usuario, posts) -> new Perfil(usuario, posts));
    }
}
