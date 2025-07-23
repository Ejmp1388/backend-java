package com.javabackend.clients.respository;

import com.javabackend.clients.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClientRepository extends MongoRepository<Client,String> {

    Optional<Client> findByEmail(String email);

    //Client findByEmail(String email);
}
