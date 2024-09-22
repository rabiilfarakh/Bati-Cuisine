package org.example.BatiCuisine.services.impl;

import org.example.BatiCuisine.dao.inter.MaterielDao;
import org.example.BatiCuisine.entities.Materiel;
import org.example.BatiCuisine.repositories.inter.MaterielRepository;
import org.example.BatiCuisine.services.inter.MaterielService;

import java.util.List;

public class MaterielServiceImpl implements MaterielService {

    private final MaterielRepository materielRepository;

    public MaterielServiceImpl(MaterielRepository materielRepository) {
        this.materielRepository = materielRepository;
    }

    @Override
    public void ajouterMateriel(Materiel materiel) {
        materielRepository.ajouterMateriel(materiel);
    }

    @Override
    public List<Materiel> afficherMaterielParProjet(Integer projetId) {
        return materielRepository.afficherMaterielParProjet(projetId);
    }

    @Override
    public void supprimerMateriel(Integer id) {
        materielRepository.supprimerMateriel(id);
    }
}
