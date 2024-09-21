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

    @Override
    public void ajouterMainDoeuvre(MainDoeuvre mainDoeuvre, Integer projetId) {

    }

    @Override
    public List<MainDoeuvre> afficherMainDoeuvreParProjet(Integer projetId) {
        return List.of();
    }

    @Override
    public void supprimerMainDoeuvre(Integer id) {

    }
}
