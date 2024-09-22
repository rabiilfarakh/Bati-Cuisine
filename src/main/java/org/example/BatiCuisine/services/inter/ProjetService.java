package org.example.BatiCuisine.services.inter;

import org.example.BatiCuisine.entities.Projet;

import java.util.List;

public interface ProjetService {
    Integer ajouterProjet(Projet projet, Integer clientId);
    Projet afficherProjet(Integer id);
    void supprimerProjet(Integer id);
    List<Projet> listerProjetsParClient(Integer clientId);
    List<Projet> listerAllProjets();
}
