package com.javabackend.clients.controller;

import com.javabackend.clients.dto.SaveNewClientDto;
import com.javabackend.clients.model.Client;
import com.javabackend.clients.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping("/save")
    public ResponseEntity<?> saveClient(@RequestBody SaveNewClientDto dto){
        try {
            Client clientResponse=clientService.saveNewClient(dto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/findbyemail/{email}")
    public ResponseEntity<?> getAllClient(@PathVariable("email") String email){
        Optional<Client> clientResponse=clientService.getClientByEmail(email);
        return ResponseEntity.ok(clientResponse);
    }

}
