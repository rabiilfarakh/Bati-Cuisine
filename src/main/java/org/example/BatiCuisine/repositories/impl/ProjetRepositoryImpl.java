package org.example.BatiCuisine.repositories.impl;

import org.example.BatiCuisine.dao.inter.ProjetDao;
import org.example.BatiCuisine.entities.Projet;
import org.example.BatiCuisine.repositories.inter.ProjetRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProjetRepositoryImpl implements ProjetRepository {

    private final ProjetDao projetDao;

    public ProjetRepositoryImpl(ProjetDao projetDao) {
        this.projetDao = projetDao;
    }

    @Override
    public Integer ajouterProjet(Projet projet, Integer clientId) {
        return projetDao.ajouterProjet(projet,clientId);
    }

    @Override
    public Projet afficherProjet(Integer id) {
        return projetDao.afficherProjet(id);
    }

    @Override
    public void supprimerProjet(Integer id) {
        projetDao.supprimerProjet(id);
    }

    @Override
    public List<Projet> listerProjetsParClient(Integer clientId) {
        return projetDao.listerProjetsParClient(clientId);
    }

    @Override
    public List<Projet> listerAllProjets() {
        return projetDao.listerAllProjets();
    }
}
