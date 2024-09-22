package org.example.BatiCuisine.repositories.inter;

import org.example.BatiCuisine.entities.Materiel;

import java.util.List;

public interface MaterielRepository {
    void ajouterMateriel(Materiel materiel);
    List<Materiel> afficherMaterielParProjet(Integer projetId);
    void supprimerMateriel(Integer id);
}
