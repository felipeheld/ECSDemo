package com.example.demo.controller;

import java.util.Optional;

import com.example.demo.model.Account;
import com.example.demo.model.AccountType;
import com.example.demo.model.Client;
import com.example.demo.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client/v1")
public class ClientController {

    @Autowired
    private ClientService _clientService;

    @GetMapping
    public ResponseEntity<Client> get(
        @RequestParam(required = false, name = "id") Long id,
        @RequestParam(required = false, name = "name") String name) { 

        Optional<Client> client = Optional.empty();

        if (id != null) {
            client = _clientService.get(id);
        } else if (name != null) {
            client = _clientService.get(name);
        }

        return client.isPresent()
            ? ResponseEntity.ok(client.get())
            : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody Client client) {
        
        Optional<Client> persistedClient = Optional.of(_clientService.persist(client));

        return persistedClient.isPresent() 
            ? ResponseEntity.ok(persistedClient.get())
            : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody Client client) {
        ResponseEntity<String> response = ResponseEntity.ok("Entity successfully deleted");
        
        try {
            _clientService.delete(client);            
        } catch(Exception e) {
            response = ResponseEntity.badRequest().body("Could not delete entity");
        }

        return response;
    }

}