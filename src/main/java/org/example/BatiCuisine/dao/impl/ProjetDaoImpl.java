package org.example.BatiCuisine.dao.impl;

import org.example.BatiCuisine.dao.inter.ProjetDao;
import org.example.BatiCuisine.entities.Projet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjetDaoImpl implements ProjetDao {

    private Connection connection;

    public ProjetDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void ajouterProjet(Projet projet, Integer clientId) {
        String sql = "INSERT INTO projets (nomprojet, margebeneficiaire, couttotal, etatprojet, client_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, projet.getNomProjet());
            preparedStatement.setDouble(2, projet.getMargeBeneficiaire());
            preparedStatement.setDouble(3, projet.getCoutTotal());
            preparedStatement.setString(4, projet.getEtatProjet().name());
            preparedStatement.setInt(5, clientId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'ajout du projet : " + e.getMessage(), e);
        }
    }

    @Override
    public Projet afficherProjet(Integer id) {
        //en cours de realisation
        return null;
    }


    @Override
    public void supprimerProjet(Integer id) {
        String sql = "DELETE FROM projets WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la suppression du projet : " + e.getMessage(), e);
        }
    }

    @Override
    public List<Projet> listerProjetsParClient(Integer clientId) {
        // en cours
        return null;
    }
}
