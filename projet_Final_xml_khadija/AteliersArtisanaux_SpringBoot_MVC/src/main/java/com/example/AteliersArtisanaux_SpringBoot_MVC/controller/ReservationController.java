package com.example.AteliersArtisanaux_SpringBoot_MVC.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.AteliersArtisanaux_SpringBoot_MVC.models.Atelier;
import com.example.AteliersArtisanaux_SpringBoot_MVC.models.Client;
import com.example.AteliersArtisanaux_SpringBoot_MVC.models.Reservation;
import com.example.AteliersArtisanaux_SpringBoot_MVC.service.ReservationService;
import com.example.AteliersArtisanaux_SpringBoot_MVC.service.ClientService;
import com.example.AteliersArtisanaux_SpringBoot_MVC.service.AtelierService;

@Controller // Indique que cette classe est un contrôleur Spring MVC
@RequestMapping("/reservations") // Définit le préfixe de l'URL pour les requêtes traitées par ce contrôleur
public class ReservationController {

    private final ReservationService reservationService; // Service pour gérer les opérations sur les réservations
    private final ClientService clientService; // Service pour gérer les opérations sur les clients
    private final AtelierService atelierService; // Service pour gérer les opérations sur les ateliers

    @Autowired // Injection de dépendances des services dans le contrôleur
    public ReservationController(ReservationService reservationService, 
                                 ClientService clientService, 
                                 AtelierService atelierService) {
        this.reservationService = reservationService;
        this.clientService = clientService;
        this.atelierService = atelierService;
    }

 // Méthode pour afficher la liste des réservations
    @GetMapping
    public String listReservations(Model model) {
        List<Reservation> reservations = reservationService.getAllReservations();
        model.addAttribute("reservations", reservations); // Ajoute la liste des réservations à l'objet Model
        return "reservations/list"; // Retourne le nom de la vue à afficher (dans ce cas, "reservations/list.html")
    }


    // Méthode pour afficher les détails d'une réservation spécifique
    @GetMapping("/{id}")
    public String viewReservation(@PathVariable Long id, Model model) {
        model.addAttribute("reservation", reservationService.getReservationById(id).orElse(null)); // Ajoute la réservation correspondant à l'ID à l'objet Model
        return "reservations/view"; // Retourne le nom de la vue à afficher (dans ce cas, "reservations/view.html")
    }

    // Méthode pour afficher le formulaire de création d'une réservation
    @GetMapping("/create")
    public String createReservationForm(Model model) {
        model.addAttribute("reservation", new Reservation()); // Ajoute un nouvel objet Reservation à l'objet Model pour le formulaire de création
        model.addAttribute("clients", clientService.getAllClients()); // Ajoute la liste des clients à l'objet Model pour le choix du client dans le formulaire
        model.addAttribute("ateliers", atelierService.getAllAteliers()); // Ajoute la liste des ateliers à l'objet Model pour le choix de l'atelier dans le formulaire
        return "reservations/create"; // Retourne le nom de la vue à afficher (dans ce cas, "reservations/create.html")
    }

 // Méthode pour créer une nouvelle réservation
    @PostMapping("/create")
    public String createReservation(@RequestParam("dateReservation") @DateTimeFormat(pattern = "yyyy-MM-dd") java.util.Date dateReservation,
                                    @RequestParam("clientId") Long clientId,
                                    @RequestParam("atelierId") Long atelierId) {
        // Récupérer le client et l'atelier à partir de leurs identifiants
        Client client = clientService.getClientById(clientId).orElse(null);
        Atelier atelier = atelierService.getAtelierById(atelierId).orElse(null);
        
        // Vérifier si le client et l'atelier existent
        if (client == null || atelier == null) {
            // Gérer le cas où le client ou l'atelier n'existe pas
            return "redirect:/reservations/create?error";
        }
        
        // Créer une nouvelle réservation
        Reservation reservation = new Reservation();
        reservation.setDateReservation(dateReservation);
        reservation.setClient(client);
        reservation.setAtelier(atelier);
        
        // Enregistrer la nouvelle réservation
        reservationService.saveReservation(reservation);
        
        // Rediriger vers la liste des réservations après la création
        return "redirect:/reservations";
    }


    // Méthode pour supprimer une réservation
    @GetMapping("/{id}/delete")
    public String deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservationById(id); // Supprime la réservation correspondant à l'ID spécifié
        return "redirect:/reservations"; // Redirige vers la liste des réservations après la suppression
    }
    
 // Méthode pour afficher le formulaire d'édition d'une réservation
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        // Récupérer la réservation à éditer
        Reservation existingReservation = reservationService.getReservationById(id).orElse(null);
        if (existingReservation == null) {
            // Gérer le cas où la réservation n'existe pas
            return "redirect:/reservations"; // Rediriger vers la liste des réservations
        }

        // Récupérer la liste des clients et des ateliers pour le formulaire
        List<Client> clients = clientService.getAllClients();
        List<Atelier> ateliers = atelierService.getAllAteliers();

        // Ajouter la réservation, les clients et les ateliers à l'objet Model
        model.addAttribute("reservation", existingReservation);
        model.addAttribute("clients", clients);
        model.addAttribute("ateliers", ateliers);

        // Retourner le nom de la vue pour le formulaire d'édition
        return "reservations/edit";
    }


    // Méthode pour mettre à jour une réservation existante
    @PostMapping("/{id}/edit")
    public String updateReservation(@PathVariable Long id,
                                    @RequestParam("dateReservation") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime dateReservation,
                                    @RequestParam("clientId") Long clientId,
                                    @RequestParam("atelierId") Long atelierId) {
        // Récupérer la réservation à mettre à jour
        Reservation existingReservation = reservationService.getReservationById(id).orElse(null);

        // Vérifier si la réservation existe
        if (existingReservation == null) {
            // Gérer le cas où la réservation n'existe pas
            return "redirect:/reservations"; // Rediriger vers la liste des réservations
        }

        // Récupérer le client et l'atelier à partir de leurs identifiants
        Client client = clientService.getClientById(clientId).orElse(null);
        Atelier atelier = atelierService.getAtelierById(atelierId).orElse(null);

        // Vérifier si le client et l'atelier existent
        if (client == null || atelier == null) {
            // Gérer le cas où le client ou l'atelier n'existe pas
            return "redirect:/reservations"; // Rediriger vers la liste des réservations
        }

        // Convertir LocalDateTime en Timestamp
        Timestamp timestamp = Timestamp.valueOf(dateReservation);

        // Mettre à jour les données de la réservation
        existingReservation.setDateReservation(timestamp);
        existingReservation.setClient(client);
        existingReservation.setAtelier(atelier);

        // Enregistrer les modifications de la réservation
        reservationService.saveReservation(existingReservation);

        // Rediriger vers la liste des réservations après la mise à jour
        return "redirect:/reservations";
    }


    
}
