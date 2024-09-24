package org.example.BatiCuisine.view;

import org.example.BatiCuisine.config.Database;
import org.example.BatiCuisine.dao.impl.*;
import org.example.BatiCuisine.dao.inter.*;
import org.example.BatiCuisine.entities.Projet;
import org.example.BatiCuisine.repositories.impl.*;
import org.example.BatiCuisine.repositories.inter.*;
import org.example.BatiCuisine.services.impl.*;
import org.example.BatiCuisine.services.inter.*;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import static org.example.BatiCuisine.entities.Projet.afficherDetailsProjet;

public class MainView {

    private static final Scanner scanner = new Scanner(System.in);

    // Static service instances
    private static ProjetService projetService;
    private static DevisService devisService;
    private static ClientService clientService;
    private static MainDoeuvreService mainDoeuvreService;
    private static MaterielService materielService;

    public MainView() {
        // Connection
        Connection connection = Database.getInstance().getConnection();

        // Initialize static service instances
        projetService = createProjetService(connection);
        devisService = createDevisService(connection);
        mainDoeuvreService = createMainDoeuvreService(connection);
        materielService = createMaterielService(connection);
        clientService = createClientService(connection);
    }

    private static ProjetService createProjetService(Connection connection) {
        ProjetDao projetDao = new ProjetDaoImpl(connection);
        ProjetRepository projetRepository = new ProjetRepositoryImpl(projetDao);
        return new ProjetServiceImpl(projetRepository);
    }

    private static DevisService createDevisService(Connection connection) {
        DevisDao devisDao = new DevisDaoImpl(connection);
        DevisRepository devisRepository = new DevisRepositoryImpl(devisDao);
        return new DevisServiceImpl(devisRepository);
    }

    private static MainDoeuvreService createMainDoeuvreService(Connection connection) {
        MainDoeuvreDao mainDoeuvreDao = new MainDoeuvreDaoImpl(connection);
        MainDoeuvreRepository mainDoeuvreRepository = new MainDoeuvreRepositoryImpl(mainDoeuvreDao);
        return new MainDoeuvreServiceImpl(mainDoeuvreRepository);
    }

    private static MaterielService createMaterielService(Connection connection) {
        MaterielDao materielDao = new MaterielDaoImpl(connection);
        MaterielRepository materielRepository = new MaterielRepositoryImpl(materielDao);
        return new MaterielServiceImpl(materielRepository);
    }

    private static ClientService createClientService(Connection connection) {
        ClientDao clientDao = new ClientDaoImpl(connection);
        ClientRepository clientRepository = new ClientRepositoryImpl(clientDao);
        return new ClientServiceImpl(clientRepository);
    }

    public void view() {
        while (true) {
            System.out.println("=== Menu Principal ===");
            System.out.println("1. Créer un nouveau projet");
            System.out.println("2. Afficher les projets existants");
            System.out.println("3. Calculer le coût d'un projet");
            System.out.println("4. Quitter");
            System.out.print("Choisissez une option : ");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    ClientView.rechercherOuAjouterClient();
                    break;
                case 2:
                    System.out.println("Affichage des projets existants...");
                    List<Projet> projets = projetService.listerAllProjets();
                    if (projets.isEmpty()) {
                        System.out.println("Aucun projet trouvé.");
                    } else {
                        for (Projet projet : projets) {
                            System.out.println(projet);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Affichage des projets existants...");
                    List<Projet> projets1 = projetService.listerAllProjets();
                    if (projets1.isEmpty()) {
                        System.out.println("Aucun projet trouvé.");
                    } else {
                        for (Projet projet : projets1) {
                            System.out.println(projet);
                        }
                    }
                    System.out.println("Enter l'id de projet a calculer ");
                    Integer id = scanner.nextInt();
                    scanner.nextLine();

                    Projet projet = projetService.afficherProjet(id);
                    afficherDetailsProjet(projet);

                    break;
                case 4:
                    System.out.println("Au revoir !");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Option invalide.");
            }
        }
    }

    // Static getters for services
    public static ProjetService getProjetService() {
        return projetService;
    }

    public static DevisService getDevisService() {
        return devisService;
    }

    public static ClientService getClientService() {
        return clientService;
    }

    public static MainDoeuvreService getMainDoeuvreService() {
        return mainDoeuvreService;
    }

    public static MaterielService getMaterielService() {
        return materielService;
    }
}
