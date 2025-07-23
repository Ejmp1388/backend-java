package com.javabackend.clients.service;


import com.javabackend.clients.dto.SaveNewClientDto;
import com.javabackend.clients.model.Client;
import com.javabackend.clients.respository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client saveNewClient(SaveNewClientDto dto) throws Exception{

        Client client=mapDtoToClient(dto);
        if(clientRepository.findByEmail(dto.getEmail()).isPresent()){
            throw new Exception("Ya existe un usuario con ese correo.");
        }
        return clientRepository.save(client);

    }

    public Optional<Client> getClientByEmail(String email){
        return clientRepository.findByEmail(email);
    }

    private Client mapDtoToClient(SaveNewClientDto dto){
        Client client=new Client();
        client.setEmail(dto.getEmail());
        client.setName(dto.getName());
        return client;
    }
}
