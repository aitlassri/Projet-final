package com.example.AteliersArtisanaux_SpringBoot_MVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.AteliersArtisanaux_SpringBoot_MVC.models.Artisan;
import com.example.AteliersArtisanaux_SpringBoot_MVC.service.ArtisanService;

@Controller // Indique que cette classe est un contrôleur Spring MVC
@RequestMapping("/artisans") // Définit le préfixe de l'URL pour les requêtes traitées par ce contrôleur
public class ArtisanController {

    private final ArtisanService artisanService; // Service pour gérer les opérations sur les artisans

    @Autowired // Injection de dépendance du service ArtisanService dans le contrôleur
    public ArtisanController(ArtisanService artisanService) {
        this.artisanService = artisanService;
    }

    // Méthode pour afficher la liste des artisans
    @GetMapping
    public String listArtisans(Model model) {
        model.addAttribute("artisans", artisanService.getAllArtisans()); // Ajoute la liste des artisans à l'objet Model
        return "artisans/list"; // Retourne le nom de la vue à afficher (dans ce cas, "artisans/list.html")
    }

    // Méthode pour afficher les détails d'un artisan spécifique
    @GetMapping("/{id}")
    public String viewArtisan(@PathVariable Long id, Model model) {
        model.addAttribute("artisan", artisanService.getArtisanById(id).orElse(null)); // Ajoute l'artisan correspondant à l'ID à l'objet Model
        return "artisans/view"; // Retourne le nom de la vue à afficher (dans ce cas, "artisans/view.html")
    }

    // Méthode pour afficher le formulaire de création d'un artisan
    @GetMapping("/create")
    public String createArtisanForm(Model model) {
        model.addAttribute("artisan", new Artisan()); // Ajoute un nouvel objet Artisan à l'objet Model pour le formulaire de création
        return "artisans/create"; // Retourne le nom de la vue à afficher (dans ce cas, "artisans/create.html")
    }

    // Méthode pour créer un nouvel artisan
    @PostMapping("/create")
    public String createArtisan(@ModelAttribute Artisan artisan) {
        artisanService.saveArtisan(artisan); // Enregistre le nouvel artisan
        return "redirect:/artisans"; // Redirige vers la liste des artisans après la création
    }

    // Méthode pour supprimer un artisan
    @GetMapping("/{id}/delete")
    public String deleteArtisan(@PathVariable Long id) {
        artisanService.deleteArtisanById(id); // Supprime l'artisan correspondant à l'ID spécifié
        return "redirect:/artisans"; // Redirige vers la liste des artisans après la suppression
    }
}
