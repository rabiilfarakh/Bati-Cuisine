package org.example.BatiCuisine.dao.impl;

import org.example.BatiCuisine.dao.inter.DevisDao;
import org.example.BatiCuisine.entities.Devis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DevisDaoImpl implements DevisDao {

    Connection connection;

    public DevisDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void ajouterDevis(Devis devis) {

        String sql = "INSERT INTO devis (montantestime, dateemission, datevalidite, accepte, projet_id) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setDouble(1, devis.getMontantEstime());
            preparedStatement.setDate(2, new java.sql.Date(devis.getDateEmission().getTime()));
            preparedStatement.setDate(3, new java.sql.Date(devis.getDateValidite().getTime()));
            preparedStatement.setBoolean(4, devis.isAccepte());
            preparedStatement.setInt(5, devis.getProjet().getId());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Le devis a été ajouté avec succès !");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du devis : " + e.getMessage());
        }
    }

}
