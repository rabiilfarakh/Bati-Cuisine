package org.example.BatiCuisine.dao.inter;

import org.example.BatiCuisine.entities.Projet;

import java.util.List;

public interface ProjetDao {
    void ajouterProjet(Projet projet, Integer clientId);
    Projet afficherProjet(Integer id);
    void supprimerProjet(Integer id);
    List<Projet> listerProjetsParClient(Integer clientId);
}
