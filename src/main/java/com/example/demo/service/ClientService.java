package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.Client;
import com.example.demo.repository.IClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    
    @Autowired
    private IClientRepository<Client> _clientRepo;

    public Optional<Client> get(Long id) {
        return _clientRepo.findById(id);
    }

    public Optional<Client> get(String name) {
        return Optional.ofNullable(_clientRepo.findByName(name));
    }

    public Iterable<Client> getAll() {
        return _clientRepo.findAll();
    }

    public Client persist(Client client) {
        return _clientRepo.save(client);
    }

    public void delete(Client client) {
        _clientRepo.delete(client);
    }

    public void deleteById(Long id) {
        _clientRepo.deleteById(id);
    }
}
