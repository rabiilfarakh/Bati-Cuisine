package org.example.BatiCuisine.dao.impl;

import org.example.BatiCuisine.dao.inter.ProjetDao;
import org.example.BatiCuisine.entities.Client;
import org.example.BatiCuisine.entities.Projet;
import org.example.BatiCuisine.entities.MainDoeuvre;
import org.example.BatiCuisine.entities.Materiel;
import org.example.BatiCuisine.enums.EtatProjet;

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
        String sql = "SELECT p.nomprojet, p.margebeneficiaire, p.couttotal, p.etatprojet, " +
                "c.nom AS client_nom, c.adresse AS client_adresse, p.surface " +
                "FROM projets p " +
                "JOIN clients c ON p.client_id = c.id " +
                "WHERE p.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                // Récupérer les informations du projet
                String nomProjet = resultSet.getString("nomprojet");
                double margeBeneficiaire = resultSet.getDouble("margebeneficiaire");
                double coutTotal = resultSet.getDouble("couttotal");
                String etatProjetStr = resultSet.getString("etatprojet");
                EtatProjet etatProjet = EtatProjet.valueOf(etatProjetStr);
                double surface = resultSet.getDouble("surface");

                // Récupérer les informations du client
                String clientNom = resultSet.getString("client_nom");
                String clientAdresse = resultSet.getString("client_adresse");

                // Créer le projet et le client
                Client client = new Client();
                client.setNom(clientNom);
                client.setAdresse(clientAdresse);

                return new Projet(nomProjet, margeBeneficiaire, coutTotal, surface, etatProjet, client, new ArrayList<>(), new ArrayList<>());
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'affichage du projet : " + e.getMessage(), e);
        }
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
        List<Projet> projets = new ArrayList<>();
        String sql = "SELECT p.nomprojet, p.margebeneficiaire, p.couttotal, p.etatprojet, " +
                "c.nom AS client_nom, c.adresse AS client_adresse, p.surface " +
                "FROM projets p " +
                "JOIN clients c ON p.client_id = c.id " +
                "WHERE p.client_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, clientId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // Récupérer les informations du projet
                String nomProjet = resultSet.getString("nomprojet");
                double margeBeneficiaire = resultSet.getDouble("margebeneficiaire");
                double coutTotal = resultSet.getDouble("couttotal");
                String etatProjetStr = resultSet.getString("etatprojet");
                EtatProjet etatProjet = EtatProjet.valueOf(etatProjetStr);
                double surface = resultSet.getDouble("surface");

                // Récupérer les informations du client
                String clientNom = resultSet.getString("client_nom");
                String clientAdresse = resultSet.getString("client_adresse");

                // Créer le projet et le client
                Client client = new Client();
                client.setNom(clientNom);
                client.setAdresse(clientAdresse);

                Projet projet = new Projet(nomProjet, margeBeneficiaire, coutTotal, surface, etatProjet, client, new ArrayList<>(), new ArrayList<>());
                projets.add(projet);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la liste des projets par client : " + e.getMessage(), e);
        }
        return projets;
    }
    @Override
    public List<Projet> listerAllProjets() {
        List<Projet> projets = new ArrayList<>();
        String sql = "SELECT p.nomprojet, p.margebeneficiaire, p.couttotal, p.etatprojet, " +
                "c.nom AS client_nom, c.adresse AS client_adresse, p.surface " +
                "FROM projets p " +
                "JOIN clients c ON p.client_id = c.id";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                // Récupérer les informations du projet
                String nomProjet = resultSet.getString("nomprojet");
                double margeBeneficiaire = resultSet.getDouble("margebeneficiaire");
                double coutTotal = resultSet.getDouble("couttotal");
                String etatProjetStr = resultSet.getString("etatprojet");
                EtatProjet etatProjet = EtatProjet.valueOf(etatProjetStr);
                double surface = resultSet.getDouble("surface");

                // Récupérer les informations du client
                String clientNom = resultSet.getString("client_nom");
                String clientAdresse = resultSet.getString("client_adresse");

                // Créer le projet et le client
                Client client = new Client();
                client.setNom(clientNom);
                client.setAdresse(clientAdresse);

                // Ajouter le projet à la liste
                projets.add(new Projet(nomProjet, margeBeneficiaire, coutTotal, surface, etatProjet, client, new ArrayList<>(), new ArrayList<>()));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération de tous les projets : " + e.getMessage(), e);
        }
        return projets;
    }



}
