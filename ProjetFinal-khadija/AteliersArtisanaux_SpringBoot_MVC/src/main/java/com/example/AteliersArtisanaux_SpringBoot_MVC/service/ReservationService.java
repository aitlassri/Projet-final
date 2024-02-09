package com.example.AteliersArtisanaux_SpringBoot_MVC.service;

import java.util.List;
import java.util.Optional;

import com.example.AteliersArtisanaux_SpringBoot_MVC.models.Reservation;

public interface ReservationService {
    List<Reservation> getAllReservations();
    Optional<Reservation> getReservationById(Long id);
    void saveReservation(Reservation reservation);
    void deleteReservationById(Long id);
}
