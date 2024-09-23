package org.example.BatiCuisine.dao.inter;

import org.example.BatiCuisine.entities.MainDoeuvre;

import java.util.List;

public interface MainDoeuvreDao {
    void ajouterMainDoeuvres(List<MainDoeuvre> mainDoeuvres);
    List<MainDoeuvre> afficherMainDoeuvreParProjet(Integer projetId);
    void supprimerMainDoeuvre(Integer id);
}
