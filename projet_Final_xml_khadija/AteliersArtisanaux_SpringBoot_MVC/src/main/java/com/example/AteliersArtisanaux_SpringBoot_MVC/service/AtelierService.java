package com.example.AteliersArtisanaux_SpringBoot_MVC.service;

import java.util.List;
import java.util.Optional;

import com.example.AteliersArtisanaux_SpringBoot_MVC.models.Atelier;

public interface AtelierService {
    List<Atelier> getAllAteliers();
    Optional<Atelier> getAtelierById(Long id);
    void saveAtelier(Atelier atelier);
    void deleteAtelierById(Long id);
}
