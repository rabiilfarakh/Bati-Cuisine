package org.example.BatiCuisine.dao.impl;

import org.example.BatiCuisine.dao.inter.MaterielDao;
import org.example.BatiCuisine.entities.Materiel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterielDaoImpl implements MaterielDao {

    private Connection connection;

    public MaterielDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void ajouterMateriel(Materiel materiel, Integer projetId) {
        String sql = "INSERT INTO materiaux (nom, tauxtva ,typecomposant ,coutunitaire, quantite, couttransport, coefficientqualite, projet_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, materiel.getNom());
            preparedStatement.setDouble(2, materiel.getTauxTVA());
            preparedStatement.setString(3, "Materiel");
            preparedStatement.setDouble(4, materiel.getCoutUnitaire());
            preparedStatement.setDouble(5, materiel.getQuantite());
            preparedStatement.setDouble(6, materiel.getCoutTransport());
            preparedStatement.setDouble(7, materiel.getCoefficientQualite());
            preparedStatement.setInt(8, projetId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'ajout du matériel : " + e.getMessage(), e);
        }
    }

    @Override
    public List<Materiel> afficherMaterielParProjet(Integer projetId) {
        List<Materiel> materiels = new ArrayList<>();
        String sql = "SELECT * FROM materiaux WHERE projet_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, projetId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Materiel materiel = new Materiel();

                    // Remplir l'objet materiel avec les données du ResultSet
                    materiel.setId(resultSet.getInt("id"));
                    materiel.setNom(resultSet.getString("nom"));
                    materiel.setTauxTVA(resultSet.getDouble("tauxtva"));
                    materiel.setCoutUnitaire(resultSet.getDouble("coutunitaire"));
                    materiel.setQuantite(resultSet.getDouble("quantite"));
                    materiel.setCoutTransport(resultSet.getDouble("couttransport"));
                    materiel.setCoefficientQualite(resultSet.getDouble("coefficientqualite"));

                    // Ajoutez l'objet à la liste
                    materiels.add(materiel);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'affichage du matériel par projet : " + e.getMessage(), e);
        }
        return materiels;
    }



    @Override
    public void supprimerMateriel(Integer id) {
        String sql = "DELETE FROM materiel WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la suppression du matériel : " + e.getMessage(), e);
        }
    }
}
