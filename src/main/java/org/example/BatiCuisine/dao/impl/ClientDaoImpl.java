package org.example.BatiCuisine.dao.impl;

import org.example.BatiCuisine.dao.inter.ClientDao;
import org.example.BatiCuisine.entities.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ClientDaoImpl implements ClientDao {

    private Connection connection;

    public ClientDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void ajouterClient(Client client) {
        String sql = "INSERT INTO clients (nom, adresse, telephone, estProfessionnel) values (?, ?, ?, ?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, client.getNom());
            preparedStatement.setString(2, client.getAdresse());
            preparedStatement.setString(3, client.getTelephone());
            preparedStatement.setBoolean(4, client.isEstProfessionnel());
            preparedStatement.executeUpdate();
        }catch(SQLException e){
            throw new RuntimeException();
        }
    }

    @Override
    public Optional<Client> afficherInformations(Integer id) {
        String sql = "SELECT * FROM clients WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Client client = new Client(
                            resultSet.getString("nom"),
                            resultSet.getString("adresse"),
                            resultSet.getString("telephone"),
                            resultSet.getBoolean("estProfessionnel")
                    );
                    return Optional.of(client);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return Optional.empty();
    }

    @Override
    public void appliquerRemise() {

    }

    @Override
    public Map<String, Client> chercherClient(String valeur) {
        String sql = "SELECT * FROM clients c WHERE c.nom LIKE ?" +
                " OR c.adresse LIKE ?" +
                " OR c.telephone LIKE ?";
        Map<String, Client> clientsTrouves = new HashMap<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            for (int i = 1; i <= 3; i++) {
                preparedStatement.setString(i, "%" + valeur + "%");
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Client client = new Client(
                            resultSet.getString("nom"),
                            resultSet.getString("adresse"),
                            resultSet.getString("telephone"),
                            resultSet.getBoolean("estProfessionnel")
                    );
                    clientsTrouves.put(client.getNom(), client);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la recherche des clients : " + e.getMessage(), e);
        }
        return clientsTrouves;
    }

}

