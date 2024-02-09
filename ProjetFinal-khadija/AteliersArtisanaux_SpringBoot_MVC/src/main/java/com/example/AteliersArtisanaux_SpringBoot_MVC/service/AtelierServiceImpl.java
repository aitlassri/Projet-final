package com.example.AteliersArtisanaux_SpringBoot_MVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.AteliersArtisanaux_SpringBoot_MVC.models.Atelier;
import com.example.AteliersArtisanaux_SpringBoot_MVC.repository.AtelierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AtelierServiceImpl implements AtelierService {

    private final AtelierRepository atelierRepository;

    @Autowired
    public AtelierServiceImpl(AtelierRepository atelierRepository) {
        this.atelierRepository = atelierRepository;
    }

    @Override
    public List<Atelier> getAllAteliers() {
        return atelierRepository.findAll();
    }

    @Override
    public Optional<Atelier> getAtelierById(Long id) {
        return atelierRepository.findById(id);
    }

    @Override
    @Transactional
    public void saveAtelier(Atelier atelier) {
        atelierRepository.save(atelier);
    }

    @Override
    @Transactional
    public void deleteAtelierById(Long id) {
        atelierRepository.deleteById(id);
    }
}

