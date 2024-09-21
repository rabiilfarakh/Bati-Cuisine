package org.example.BatiCuisine.services.inter;

import org.example.BatiCuisine.entities.Materiel;

import java.util.List;

public interface MaterielService {
    void ajouterMateriel(Materiel materiel, Integer projetId);
    List<Materiel> afficherMaterielParProjet(Integer projetId);
    void supprimerMateriel(Integer id);
}
