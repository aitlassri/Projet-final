package com.example.AteliersArtisanaux_SpringBoot_MVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.AteliersArtisanaux_SpringBoot_MVC.models.Reservation;
import com.example.AteliersArtisanaux_SpringBoot_MVC.repository.ReservationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    @Transactional
    public void saveReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    @Transactional
    public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);
    }
}

