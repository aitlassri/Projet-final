package com.example.AteliersArtisanaux_SpringBoot_MVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AteliersArtisanaux_SpringBoot_MVC.models.Atelier;

// Interface permettant d'accéder aux données de la table Atelier dans la base de données
// JpaRepository fournit des méthodes prédéfinies pour effectuer des opérations CRUD (Create, Read, Update, Delete) sur la table Atelier
// L'annotation JpaRepository prend deux paramètres : le type d'entité (Atelier) et le type de l'identifiant de l'entité (Long)
public interface AtelierRepository extends JpaRepository<Atelier, Long> {
    // Vous pouvez ajouter des méthodes spécifiques si nécessaire
}
