package com.example.AteliersArtisanaux_SpringBoot_MVC.models;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Indique que cette classe est une entité JPA et sera persistée dans une base de données
@Table(name = "artisans")
public class Artisan {
    @Id // Définit que 'id' est la clé primaire de cette entité
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génère automatiquement des valeurs d'identifiant uniques
    private Long id;

    private String nom; // Nom de l'artisan
    private String email; // Email de l'artisan

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Méthode toString() pour afficher les informations de l'artisan
    @Override
    public String toString() {
        return "Artisan{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    // Méthodes equals() et hashCode() pour comparer les objets Artisan
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artisan artisan = (Artisan) o;
        return Objects.equals(id, artisan.id) &&
                Objects.equals(nom, artisan.nom) &&
                Objects.equals(email, artisan.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, email);
    }
}
