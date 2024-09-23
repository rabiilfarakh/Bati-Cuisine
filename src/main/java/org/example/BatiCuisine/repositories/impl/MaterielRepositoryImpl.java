package org.example.BatiCuisine.repositories.impl;

import org.example.BatiCuisine.dao.inter.MaterielDao;
import org.example.BatiCuisine.entities.Materiel;
import org.example.BatiCuisine.repositories.inter.MaterielRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterielRepositoryImpl implements MaterielRepository {

    private final MaterielDao materielDao;

    public MaterielRepositoryImpl(MaterielDao materielDao) {
        this.materielDao = materielDao;
    }

    @Override
    public void ajouterMateriels(List<Materiel> materiaux) {
        materielDao.ajouterMateriels(materiaux);
    }

    @Override
    public List<Materiel> afficherMaterielParProjet(Integer projetId) {
        return materielDao.afficherMaterielParProjet(projetId);
    }

    @Override
    public void supprimerMateriel(Integer id) {
        materielDao.supprimerMateriel(id);
    }
}
