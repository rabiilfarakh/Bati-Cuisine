package org.example.BatiCuisine.repositories.inter;

import org.example.BatiCuisine.entities.MainDoeuvre;

import java.util.List;

public interface MainDoeuvreRepository {
    void ajouterMainDoeuvres(List<MainDoeuvre> mainDoeuvres);
    List<MainDoeuvre> afficherMainDoeuvreParProjet(Integer projetId);
    void supprimerMainDoeuvre(Integer id);
}
