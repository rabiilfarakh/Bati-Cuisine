package org.example.BatiCuisine.dao.inter;

import org.example.BatiCuisine.entities.Materiel;

import java.util.List;

public interface MaterielDao {
    void ajouterMateriel(Materiel materiel);
    List<Materiel> afficherMaterielParProjet(Integer projetId);
    void supprimerMateriel(Integer id);
}
