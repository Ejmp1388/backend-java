package com.backend.tareareactiva.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.backend.tareareactiva.model.Auto;

@Repository
public interface AutoRepository extends ReactiveMongoRepository<Auto,Integer> {
}
