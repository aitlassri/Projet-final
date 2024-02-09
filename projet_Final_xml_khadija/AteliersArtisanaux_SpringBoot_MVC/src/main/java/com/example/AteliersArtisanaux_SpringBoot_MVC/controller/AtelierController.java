package com.example.AteliersArtisanaux_SpringBoot_MVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.AteliersArtisanaux_SpringBoot_MVC.models.Atelier;
import com.example.AteliersArtisanaux_SpringBoot_MVC.service.AtelierService;

@Controller // Indique que cette classe est un contrôleur Spring MVC
@RequestMapping("/ateliers") // Définit le préfixe de l'URL pour les requêtes traitées par ce contrôleur
public class AtelierController {

    private final AtelierService atelierService; // Service pour gérer les opérations sur les ateliers

    @Autowired // Injection de dépendance du service AtelierService dans le contrôleur
    public AtelierController(AtelierService atelierService) {
        this.atelierService = atelierService;
    }

    // Méthode pour afficher la liste des ateliers
    @GetMapping
    public String listAteliers(Model model) {
        model.addAttribute("ateliers", atelierService.getAllAteliers()); // Ajoute la liste des ateliers à l'objet Model
        return "ateliers/list"; // Retourne le nom de la vue à afficher (dans ce cas, "ateliers/list.html")
    }

    // Méthode pour afficher les détails d'un atelier spécifique
    @GetMapping("/{id}")
    public String viewAtelier(@PathVariable Long id, Model model) {
        model.addAttribute("atelier", atelierService.getAtelierById(id).orElse(null)); // Ajoute l'atelier correspondant à l'ID à l'objet Model
        return "ateliers/view"; // Retourne le nom de la vue à afficher (dans ce cas, "ateliers/view.html")
    }

    // Méthode pour afficher le formulaire de création d'un atelier
    @GetMapping("/create")
    public String createAtelierForm(Model model) {
        model.addAttribute("atelier", new Atelier()); // Ajoute un nouvel objet Atelier à l'objet Model pour le formulaire de création
        return "ateliers/create"; // Retourne le nom de la vue à afficher (dans ce cas, "ateliers/create.html")
    }

    // Méthode pour créer un nouvel atelier
    @PostMapping("/create")
    public String createAtelier(@ModelAttribute Atelier atelier) {
        atelierService.saveAtelier(atelier); // Enregistre le nouvel atelier
        return "redirect:/ateliers"; // Redirige vers la liste des ateliers après la création
    }

    // Méthode pour supprimer un atelier
    @GetMapping("/{id}/delete")
    public String deleteAtelier(@PathVariable Long id) {
        atelierService.deleteAtelierById(id); // Supprime l'atelier correspondant à l'ID spécifié
        return "redirect:/ateliers"; // Redirige vers la liste des ateliers après la suppression
    }
}
