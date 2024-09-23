package org.example.BatiCuisine.services.impl;

import org.example.BatiCuisine.dao.inter.DevisDao;
import org.example.BatiCuisine.entities.Devis;
import org.example.BatiCuisine.repositories.inter.DevisRepository;
import org.example.BatiCuisine.services.inter.DevisService;

public class DevisServiceImpl implements DevisService {

    private final DevisRepository devisRepository;

    public DevisServiceImpl(DevisRepository devisRepository) {
        this.devisRepository = devisRepository;
    }

    @Override
    public void ajouterDevis(Devis devis) {
        devisRepository.ajouterDevis(devis);
    }
}
