package com.example.AteliersArtisanaux_SpringBoot_MVC.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.AteliersArtisanaux_SpringBoot_MVC.models.Artisan;
import com.example.AteliersArtisanaux_SpringBoot_MVC.repository.ArtisanRepository;

import java.util.List;
import java.util.Optional;

@Service // Annoter la classe comme service pour que Spring gère sa création et son cycle de vie.
@Transactional // Annoter la classe pour indiquer que toutes les méthodes publiques sont exécutées
// dans le cadre d'une transaction.
public class ArtisanServiceImpl implements ArtisanService {

	 private final ArtisanRepository artisanRepository; // Déclaration du repository pour les artisans.

	 @Autowired // Utilisation de l'injection de dépendance pour injecter une instance de ArtisanRepository.
	    public ArtisanServiceImpl(ArtisanRepository artisanRepository) {
	        // Affectation du repository injecté au champ de la classe.
	        this.artisanRepository = artisanRepository;
	    }

	 
	  @Override // Implémentation de la méthode pour obtenir tous les artisans.
	   public List<Artisan> getAllArtisans() {
        return artisanRepository.findAll(); // Appel du repository pour obtenir tous les artisans.
          }

	  @Override // Implémentation de la méthode pour obtenir un artisan par son ID.
	   public Optional<Artisan> getArtisanById(Long id) {
        return artisanRepository.findById(id);// Appel du repository pour trouver l'artisan.
        
    }

    @Override // Implémentation de la méthode pour enregistrer un artisan.
       public void saveArtisan(Artisan artisan) {
        artisanRepository.save(artisan);// Appel du repository pour enregistrer l'artisan.   
    }

    @Override // Implémentation de la méthode pour supprimer un artisan par son ID.
        public void deleteArtisanById(Long id) {
        artisanRepository.deleteById(id);
    }
}

