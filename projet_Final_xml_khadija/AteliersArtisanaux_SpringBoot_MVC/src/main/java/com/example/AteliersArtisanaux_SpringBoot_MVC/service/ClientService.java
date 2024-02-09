package com.example.AteliersArtisanaux_SpringBoot_MVC.service;

import java.util.List;
import java.util.Optional;

import com.example.AteliersArtisanaux_SpringBoot_MVC.models.Client;

public interface ClientService {
    List<Client> getAllClients();
    Optional<Client> getClientById(Long id);
    void saveClient(Client client);
    void deleteClientById(Long id);
}
