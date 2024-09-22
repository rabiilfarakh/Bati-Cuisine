package org.example.BatiCuisine.dao.impl;

import org.example.BatiCuisine.dao.inter.MainDoeuvreDao;
import org.example.BatiCuisine.entities.MainDoeuvre;
import org.example.BatiCuisine.enums.TypeComposant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MainDoeuvreDaoImpl implements MainDoeuvreDao {

    private Connection connection;

    public MainDoeuvreDaoImpl(Connection connection) {

        this.connection = connection;
    }

    @Override
    public void ajouterMainDoeuvre(MainDoeuvre mainDoeuvre) {
        String sql = "INSERT INTO main_d_oeuvre (nom, tauxtva, typecomposant, projet_id, tauxhoraire, heurestravail, productiviteouvrier) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, mainDoeuvre.getNom());
            preparedStatement.setDouble(2, mainDoeuvre.getTauxTVA());

            // Use setObject to insert the enum directly
            preparedStatement.setObject(3, mainDoeuvre.getTypeComposant().name(), Types.OTHER);

            preparedStatement.setInt(4, mainDoeuvre.getProjet().getId());
            preparedStatement.setDouble(5, mainDoeuvre.getTauxHoraire());
            preparedStatement.setDouble(6, mainDoeuvre.getHeuresTravail());
            preparedStatement.setDouble(7, mainDoeuvre.getProductiviteOuvrier());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'ajout de la main d'œuvre : " + e.getMessage(), e);
        }
    }


    @Override
    public List<MainDoeuvre> afficherMainDoeuvreParProjet(Integer projetId) {
        List<MainDoeuvre> mainDoeuvres = new ArrayList<>();
        String sql = "SELECT * FROM main_d_oeuvre WHERE projet_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, projetId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    MainDoeuvre mainDoeuvre = new MainDoeuvre();

                    // Remplir l'objet mainDoeuvre avec les données du ResultSet
                    mainDoeuvre.setId(resultSet.getInt("id"));
                    mainDoeuvre.setNom(resultSet.getString("nom"));
                    mainDoeuvre.setTauxTVA(resultSet.getDouble("tauxtva"));
                    mainDoeuvre.setTauxHoraire(resultSet.getDouble("tauxhoraire"));
                    mainDoeuvre.setHeuresTravail(resultSet.getDouble("heurestravail"));
                    mainDoeuvre.setProductiviteOuvrier(resultSet.getDouble("productiviteouvrier"));

                    // Récupération et conversion de typeComposant
                    String typeComposantString = resultSet.getString("typecomposant");
                    if (typeComposantString != null) {
                        mainDoeuvre.setTypeComposant(TypeComposant.valueOf(typeComposantString));
                    }

                    // Ajoutez l'objet à la liste
                    mainDoeuvres.add(mainDoeuvre);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'affichage de la main d'œuvre par projet : " + e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Erreur de conversion du typeComposant : " + e.getMessage(), e);
        }
        return mainDoeuvres;
    }


    @Override
    public void supprimerMainDoeuvre(Integer id) {
        String sql = "DELETE FROM main_d_oeuvre WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la suppression de la main d'œuvre : " + e.getMessage(), e);
        }
    }
}
