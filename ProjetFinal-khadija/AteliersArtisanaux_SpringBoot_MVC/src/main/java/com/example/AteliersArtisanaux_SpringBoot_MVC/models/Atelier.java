package com.example.AteliersArtisanaux_SpringBoot_MVC.models;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity // Indique que cette classe est une entité JPA et sera persistée dans une base de données
@Table(name = "ateliers")
public class Atelier {
    @Id // Définit que 'id' est la clé primaire de cette entité
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génère automatiquement des valeurs d'identifiant uniques
    private Long id;

    private String nom; // Nom de l'atelier
    private String description; // Description de l'atelier

    @ManyToOne // Indique une relation Many-to-One entre Atelier et Artisan
    @JoinColumn(name = "artisan_id") // Spécifie la colonne dans la table Atelier qui contiendra la clé étrangère vers Artisan
    private Artisan artisan; // L'artisan responsable de l'atelier

    // Getters and setters (méthodes d'accès aux attributs)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Artisan getArtisan() {
        return artisan;
    }

    public void setArtisan(Artisan artisan) {
        this.artisan = artisan;
    }

    // Méthode toString() pour afficher les informations de l'atelier
    @Override
    public String toString() {
        return "Atelier{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", artisan=" + artisan +
                '}';
    }

    // Méthodes equals() et hashCode() pour comparer les objets Atelier
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atelier atelier = (Atelier) o;
        return Objects.equals(id, atelier.id) &&
                Objects.equals(nom, atelier.nom) &&
                Objects.equals(description, atelier.description) &&
                Objects.equals(artisan, atelier.artisan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, description, artisan);
    }
}
