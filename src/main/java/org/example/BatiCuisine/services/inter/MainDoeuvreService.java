package org.example.BatiCuisine.services.inter;

import org.example.BatiCuisine.entities.MainDoeuvre;

import java.util.List;

public interface MainDoeuvreService {
    void ajouterMainDoeuvre(MainDoeuvre mainDoeuvre);
    List<MainDoeuvre> afficherMainDoeuvreParProjet(Integer projetId);
    void supprimerMainDoeuvre(Integer id);
}
