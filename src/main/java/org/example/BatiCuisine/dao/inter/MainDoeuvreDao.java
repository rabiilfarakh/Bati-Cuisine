package org.example.BatiCuisine.dao.inter;

import org.example.BatiCuisine.entities.MainDoeuvre;

import java.util.List;

public interface MainDoeuvreDao {
    void ajouterMainDoeuvre(MainDoeuvre mainDoeuvre, Integer projetId);
    List<MainDoeuvre> afficherMainDoeuvreParProjet(Integer projetId);
    void modifierMainDoeuvre(MainDoeuvre mainDoeuvre);
    void supprimerMainDoeuvre(Integer id);
}
