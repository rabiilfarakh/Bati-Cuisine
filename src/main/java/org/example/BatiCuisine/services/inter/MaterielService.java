package org.example.BatiCuisine.services.inter;

import org.example.BatiCuisine.entities.Materiel;

import java.util.List;

public interface MaterielService {
    void ajouterMateriel(Materiel materiel);
    List<Materiel> afficherMaterielParProjet(Integer projetId);
    void supprimerMateriel(Integer id);
}
