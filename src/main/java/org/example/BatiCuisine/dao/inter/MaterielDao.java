package org.example.BatiCuisine.dao.inter;

import org.example.BatiCuisine.entities.Materiel;

import java.util.List;

public interface MaterielDao {
    void ajouterMateriel(Materiel materiel, Integer projetId);
    List<Materiel> afficherMaterielParProjet(Integer projetId);
    void modifierMateriel(Materiel materiel);
    void supprimerMateriel(Integer id);
}
