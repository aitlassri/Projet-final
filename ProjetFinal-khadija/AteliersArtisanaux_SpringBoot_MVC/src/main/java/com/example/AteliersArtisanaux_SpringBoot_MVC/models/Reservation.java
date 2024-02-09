package com.example.AteliersArtisanaux_SpringBoot_MVC.models;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity // Indique que cette classe est une entité JPA et sera persistée dans une base de données
@Table(name = "reservations")
public class Reservation {
    @Id // Définit que 'id' est la clé primaire de cette entité
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Génère automatiquement des valeurs d'identifiant uniques
    private Long id;

    private Date dateReservation; // Date de la réservation

    @ManyToOne // Indique une relation Many-to-One entre Reservation et Client
    @JoinColumn(name = "client_id") // Spécifie la colonne dans la table Reservation qui contiendra la clé étrangère vers Client
    private Client client; // Le client qui a effectué la réservation

    @ManyToOne // Indique une relation Many-to-One entre Reservation et Atelier
    @JoinColumn(name = "atelier_id") // Spécifie la colonne dans la table Reservation qui contiendra la clé étrangère vers Atelier
    private Atelier atelier; // L'atelier réservé

    // Getters and setters (méthodes d'accès aux attributs)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Atelier getAtelier() {
        return atelier;
    }

    public void setAtelier(Atelier atelier) {
        this.atelier = atelier;
    }

    // Méthode toString() pour afficher les informations de la réservation
    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", dateReservation=" + dateReservation +
                ", client=" + client +
                ", atelier=" + atelier +
                '}';
    }

    // Méthodes equals() et hashCode() pour comparer les objets Reservation
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dateReservation, that.dateReservation) &&
                Objects.equals(client, that.client) &&
                Objects.equals(atelier, that.atelier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateReservation, client, atelier);
    }
}
