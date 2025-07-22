package com.javabackend.clients.respository;

import com.javabackend.clients.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClientRepository extends MongoRepository<Client,String> {
    Client findByEmail(String email);
}
