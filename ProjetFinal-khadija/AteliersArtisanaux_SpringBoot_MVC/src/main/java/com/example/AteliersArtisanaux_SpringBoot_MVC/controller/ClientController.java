package com.example.AteliersArtisanaux_SpringBoot_MVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.AteliersArtisanaux_SpringBoot_MVC.models.Client;
import com.example.AteliersArtisanaux_SpringBoot_MVC.service.ClientService;

@Controller // Indique que cette classe est un contrôleur Spring MVC
@RequestMapping("/clients") // Définit le préfixe de l'URL pour les requêtes traitées par ce contrôleur
public class ClientController {

    private final ClientService clientService; // Service pour gérer les opérations sur les clients

    @Autowired // Injection de dépendance du service ClientService dans le contrôleur
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // Méthode pour afficher la liste des clients
    @GetMapping
    public String listClients(Model model) {
        model.addAttribute("clients", clientService.getAllClients()); // Ajoute la liste des clients à l'objet Model
        return "clients/list"; // Retourne le nom de la vue à afficher (dans ce cas, "clients/list.html")
    }

    // Méthode pour afficher les détails d'un client spécifique
    @GetMapping("/{id}")
    public String viewClient(@PathVariable Long id, Model model) {
        model.addAttribute("client", clientService.getClientById(id).orElse(null)); // Ajoute le client correspondant à l'ID à l'objet Model
        return "clients/view"; // Retourne le nom de la vue à afficher (dans ce cas, "clients/view.html")
    }

    // Méthode pour afficher le formulaire de création d'un client
    @GetMapping("/create")
    public String createClientForm(Model model) {
        model.addAttribute("client", new Client()); // Ajoute un nouvel objet Client à l'objet Model pour le formulaire de création
        return "clients/create"; // Retourne le nom de la vue à afficher (dans ce cas, "clients/create.html")
    }

    // Méthode pour créer un nouveau client
    @PostMapping("/create")
    public String createClient(@ModelAttribute Client client) {
        clientService.saveClient(client); // Enregistre le nouveau client
        return "redirect:/clients"; // Redirige vers la liste des clients après la création
    }

    // Méthode pour supprimer un client
    @GetMapping("/{id}/delete")
    public String deleteClient(@PathVariable Long id) {
        clientService.deleteClientById(id); // Supprime le client correspondant à l'ID spécifié
        return "redirect:/clients"; // Redirige vers la liste des clients après la suppression
    }
}
