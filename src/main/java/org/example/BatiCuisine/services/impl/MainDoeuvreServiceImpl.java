package org.example.BatiCuisine.services.impl;

import org.example.BatiCuisine.entities.MainDoeuvre;
import org.example.BatiCuisine.repositories.inter.MainDoeuvreRepository;
import org.example.BatiCuisine.services.inter.MainDoeuvreService;

import java.util.List;

public class MainDoeuvreServiceImpl implements MainDoeuvreService {

    private final MainDoeuvreRepository mainDoeuvreRepository;

    public MainDoeuvreServiceImpl(MainDoeuvreRepository mainDoeuvreRepository) {
        this.mainDoeuvreRepository = mainDoeuvreRepository;
    }

    @Override
    public void ajouterMainDoeuvres(List<MainDoeuvre> mainDoeuvres) {
        mainDoeuvreRepository.ajouterMainDoeuvres(mainDoeuvres);
    }

    @Override
    public List<MainDoeuvre> afficherMainDoeuvreParProjet(Integer projetId) {
        return mainDoeuvreRepository.afficherMainDoeuvreParProjet(projetId);
    }

    @Override
    public void supprimerMainDoeuvre(Integer id) {
        mainDoeuvreRepository.supprimerMainDoeuvre(id);
    }
}
