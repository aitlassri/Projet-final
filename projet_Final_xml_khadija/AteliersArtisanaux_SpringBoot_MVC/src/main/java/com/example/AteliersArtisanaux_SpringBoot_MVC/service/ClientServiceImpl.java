package com.example.AteliersArtisanaux_SpringBoot_MVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.AteliersArtisanaux_SpringBoot_MVC.models.Client;
import com.example.AteliersArtisanaux_SpringBoot_MVC.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    @Transactional
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    @Transactional
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }
}
