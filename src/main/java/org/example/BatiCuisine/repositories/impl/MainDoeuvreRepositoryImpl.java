package org.example.BatiCuisine.repositories.impl;

import org.example.BatiCuisine.dao.inter.MainDoeuvreDao;
import org.example.BatiCuisine.entities.MainDoeuvre;
import org.example.BatiCuisine.enums.TypeComposant;
import org.example.BatiCuisine.repositories.inter.MainDoeuvreRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainDoeuvreRepositoryImpl implements MainDoeuvreRepository {

    private final MainDoeuvreDao mainDoeuvreDao;

    public MainDoeuvreRepositoryImpl(MainDoeuvreDao mainDoeuvreDao) {
        this.mainDoeuvreDao = mainDoeuvreDao;
    }

    @Override
    public void ajouterMainDoeuvre(MainDoeuvre mainDoeuvre, Integer projetId) {
        mainDoeuvreDao.ajouterMainDoeuvre(mainDoeuvre,projetId);
    }

    @Override
    public List<MainDoeuvre> afficherMainDoeuvreParProjet(Integer projetId) {
        return mainDoeuvreDao.afficherMainDoeuvreParProjet(projetId);
    }

    @Override
    public void supprimerMainDoeuvre(Integer id) {
        mainDoeuvreDao.supprimerMainDoeuvre(id);
    }
}
