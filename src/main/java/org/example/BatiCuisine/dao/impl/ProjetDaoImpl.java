package org.example.BatiCuisine.dao.impl;

import org.example.BatiCuisine.dao.inter.ProjetDao;
import org.example.BatiCuisine.entities.Client;
import org.example.BatiCuisine.entities.Projet;
import org.example.BatiCuisine.entities.MainDoeuvre;
import org.example.BatiCuisine.entities.Materiel;
import org.example.BatiCuisine.enums.EtatProjet;
import org.example.BatiCuisine.enums.TypeComposant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetDaoImpl implements ProjetDao {

    private Connection connection;

    public ProjetDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Integer ajouterProjet(Projet projet, Integer clientId) {
        String sql = "INSERT INTO projets (nomprojet, margebeneficiaire, couttotal, etatprojet, client_id,surface) VALUES (?, ?, ?, ?, ?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, projet.getNomProjet());
            preparedStatement.setDouble(2, projet.getMargeBeneficiaire());
            preparedStatement.setDouble(3, projet.getCoutTotal());
            preparedStatement.setObject(4, projet.getEtatProjet().name(), Types.OTHER);
            preparedStatement.setInt(5, clientId);
            preparedStatement.setDouble(6,projet.getSurface());

            // Execute the update
            preparedStatement.executeUpdate();

            // Retrieve the generated keys
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Return the first generated key
                } else {
                    throw new SQLException("Aucune clé générée, l'insertion a échoué.");
                }
            }
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
        String sql = "SELECT p.*, " +
                "c.nom AS client_nom, c.adresse AS client_adresse, " +
                "m.nom AS materiau_nom, m.tauxtva, m.typecomposant, m.projet_id, m.coutunitaire, m.quantite, " +
                "m.couttransport, m.coefficientqualite, " +
                "mo.nom AS main_oeuvre_nom, mo.tauxtva AS mo_tauxtva, mo.typecomposant AS mo_typecomposant, " +
                "mo.projet_id AS mo_projet_id, mo.tauxhoraire, mo.heurestravail, mo.productiviteouvrier " +
                "FROM projets p " +
                "JOIN clients c ON p.client_id = c.id " +
                "JOIN materiaux m ON m.projet_id = p.id " +
                "JOIN main_d_oeuvre mo ON mo.projet_id = p.id";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nomProjet = resultSet.getString("nomprojet");
                double margeBeneficiaire = resultSet.getDouble("margebeneficiaire");
                double coutTotal = resultSet.getDouble("couttotal");
                double surface = resultSet.getDouble("surface");
                String etatProjetStr = resultSet.getString("etatprojet");
                EtatProjet etatProjet = EtatProjet.valueOf(etatProjetStr);

                String clientNom = resultSet.getString("client_nom");
                String clientAdresse = resultSet.getString("client_adresse");
                Client client = new Client();
                client.setNom(clientNom);
                client.setAdresse(clientAdresse);

                // Create lists for materials and labor
                List<Materiel> materielList = new ArrayList<>();
                List<MainDoeuvre> mainDoeuvreList = new ArrayList<>();

                // Material details
                String materiauNom = resultSet.getString("materiau_nom");
                if (materiauNom != null) {
                    Materiel materiel = new Materiel();
                    materiel.setNom(materiauNom);
                    materiel.setTauxTVA(resultSet.getDouble("tauxtva"));
                    materiel.setTypeComposant(TypeComposant.valueOf(resultSet.getString("typecomposant"))); // Enum conversion
                    materiel.setCoutUnitaire(resultSet.getDouble("coutunitaire"));
                    materiel.setQuantite(resultSet.getInt("quantite"));
                    materiel.setCoutTransport(resultSet.getDouble("couttransport"));
                    materiel.setCoefficientQualite(resultSet.getDouble("coefficientqualite"));
                    materielList.add(materiel);
                }

                // Labor details
                String mainOeuvreNom = resultSet.getString("main_oeuvre_nom");
                if (mainOeuvreNom != null) {
                    MainDoeuvre mainDoeuvre = new MainDoeuvre();
                    mainDoeuvre.setNom(mainOeuvreNom);
                    mainDoeuvre.setTauxTVA(resultSet.getDouble("mo_tauxtva"));
                    mainDoeuvre.setTypeComposant(TypeComposant.valueOf(resultSet.getString("mo_typecomposant")));
                    mainDoeuvre.setTauxHoraire(resultSet.getDouble("tauxhoraire"));
                    mainDoeuvre.setHeuresTravail(resultSet.getInt("heurestravail"));
                    mainDoeuvre.setProductiviteOuvrier(resultSet.getDouble("productiviteouvrier"));
                    mainDoeuvreList.add(mainDoeuvre);
                }

                projets.add(new Projet(nomProjet, margeBeneficiaire, coutTotal, surface, etatProjet, client, mainDoeuvreList, materielList));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération de tous les projets : " + e.getMessage(), e);
        }
        return projets;
    }



}
