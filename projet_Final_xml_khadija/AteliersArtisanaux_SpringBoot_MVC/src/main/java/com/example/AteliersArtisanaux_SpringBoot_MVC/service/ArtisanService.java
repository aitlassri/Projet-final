package com.example.AteliersArtisanaux_SpringBoot_MVC.service;

import java.util.List;
import java.util.Optional;

import com.example.AteliersArtisanaux_SpringBoot_MVC.models.Artisan;

public interface ArtisanService {
    List<Artisan> getAllArtisans();
    Optional<Artisan> getArtisanById(Long id);
    void saveArtisan(Artisan artisan);
    void deleteArtisanById(Long id);
}
