package com.microservicio.userservice.infrastructure.mongo;

import com.microservicio.userservice.domain.model.User;
import com.microservicio.userservice.domain.port.UserRepositoryPort;
import com.microservicio.userservice.infrastructure.mongo.document.UserDocument;
import com.microservicio.userservice.infrastructure.mongo.repository.UserMongoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserMongoRepository mongoRepository;

    @Override
    public Mono<User> findById(Integer id) {
        return mongoRepository.findById(id).map(this::toDomain);
    }

    @Override
    public void saveUser(User user) {
        UserDocument userDocument=new UserDocument(user.getId(),user.getNombre(),user.getEdad());
        Mono<UserDocument>userDocumentMono=mongoRepository.save(userDocument);
        userDocumentMono.subscribe(
                e->System.out.println("guardo correctamente")
        );
    }


    private User toDomain(UserDocument doc) {
        return new User(doc.getId(), doc.getNombre(), doc.getEdad());
    }



}
