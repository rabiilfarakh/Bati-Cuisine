package org.example.BatiCuisine.repositories.impl;

import org.example.BatiCuisine.dao.inter.ProjetDao;
import org.example.BatiCuisine.entities.Projet;
import org.example.BatiCuisine.repositories.inter.ProjetRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProjetRepositoryImpl implements ProjetRepository {


    @Override
    public void ajouterProjet(Projet projet, Integer clientId) {

    }

    @Override
    public Projet afficherProjet(Integer id) {
        return null;
    }

    @Override
    public void supprimerProjet(Integer id) {

    }

    @Override
    public List<Projet> listerProjetsParClient(Integer clientId) {
        return List.of();
    }
}
