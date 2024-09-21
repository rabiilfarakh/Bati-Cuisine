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


    @Override
    public void ajouterMateriel(Materiel materiel, Integer projetId) {

    }

    @Override
    public List<Materiel> afficherMaterielParProjet(Integer projetId) {
        return List.of();
    }

    @Override
    public void supprimerMateriel(Integer id) {

    }
}
