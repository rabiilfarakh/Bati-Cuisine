package org.example.BatiCuisine.repositories.inter;

import org.example.BatiCuisine.entities.MainDoeuvre;

import java.util.List;

public interface MainDoeuvreRepository {
    void ajouterMainDoeuvre(MainDoeuvre mainDoeuvre, Integer projetId);
    List<MainDoeuvre> afficherMainDoeuvreParProjet(Integer projetId);
    void supprimerMainDoeuvre(Integer id);
}
