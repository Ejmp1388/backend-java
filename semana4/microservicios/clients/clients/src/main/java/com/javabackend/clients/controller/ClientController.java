package com.javabackend.clients.controller;

import com.javabackend.clients.dto.SaveNewClientDto;
import com.javabackend.clients.model.Client;
import com.javabackend.clients.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> saveClient(@RequestBody SaveNewClientDto dto){
        Client clientResponse=clientService.saveNewClient(dto);
        return new ResponseEntity<>(clientResponse, HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Client> getAllClient(@PathVariable("email") String email){
        Client clientResponse=clientService.getClientByEmail(email);
        return new ResponseEntity<>(clientResponse, HttpStatus.OK);
    }

}
