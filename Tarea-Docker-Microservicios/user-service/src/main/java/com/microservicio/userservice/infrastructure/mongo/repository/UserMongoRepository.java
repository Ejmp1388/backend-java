package com.microservicio.userservice.infrastructure.mongo.repository;

import com.microservicio.userservice.infrastructure.mongo.document.UserDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserMongoRepository extends ReactiveMongoRepository<UserDocument, Integer> {
}
