package org.example.BatiCuisine.dao.inter;

import org.example.BatiCuisine.entities.Materiel;

import java.util.List;

public interface MaterielDao {
    void ajouterMateriels(List<Materiel> materiaux);
    List<Materiel> afficherMaterielParProjet(Integer projetId);
    void supprimerMateriel(Integer id);
}
