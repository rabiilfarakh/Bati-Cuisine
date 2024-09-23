package org.example.BatiCuisine.repositories.impl;

import org.example.BatiCuisine.dao.inter.DevisDao;
import org.example.BatiCuisine.entities.Devis;
import org.example.BatiCuisine.repositories.inter.DevisRepository;

public class DevisRepositoryImpl implements DevisRepository {

    private final DevisDao devisDao ;

    public DevisRepositoryImpl(DevisDao devisDao) {
        this.devisDao = devisDao;
    }

    @Override
    public void ajouterDevis(Devis devis) {
        devisDao.ajouterDevis(devis);
    }
}
