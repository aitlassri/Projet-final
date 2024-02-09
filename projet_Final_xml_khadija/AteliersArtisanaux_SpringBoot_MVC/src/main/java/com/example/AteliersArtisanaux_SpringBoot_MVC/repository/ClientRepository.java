package com.example.AteliersArtisanaux_SpringBoot_MVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.AteliersArtisanaux_SpringBoot_MVC.models.Client;

// Interface permettant d'accéder aux données de la table Client dans la base de données
// JpaRepository fournit des méthodes prédéfinies pour effectuer des opérations CRUD (Create, Read, Update, Delete) sur la table Client
// L'annotation JpaRepository prend deux paramètres : le type d'entité (Client) et le type de l'identifiant de l'entité (Long)
public interface ClientRepository extends JpaRepository<Client, Long> {
    // Vous pouvez ajouter des méthodes spécifiques si nécessaire
}
