package org.example.BatiCuisine.view;

import org.example.BatiCuisine.config.Database;
import org.example.BatiCuisine.dao.impl.ClientDaoImpl;
import org.example.BatiCuisine.dao.impl.MainDoeuvreDaoImpl;
import org.example.BatiCuisine.dao.impl.MaterielDaoImpl;
import org.example.BatiCuisine.dao.impl.ProjetDaoImpl;
import org.example.BatiCuisine.dao.inter.ClientDao;
import org.example.BatiCuisine.dao.inter.MainDoeuvreDao;
import org.example.BatiCuisine.dao.inter.MaterielDao;
import org.example.BatiCuisine.dao.inter.ProjetDao;
import org.example.BatiCuisine.entities.Projet;
import org.example.BatiCuisine.repositories.impl.ClientRepositoryImpl;
import org.example.BatiCuisine.repositories.impl.MainDoeuvreRepositoryImpl;
import org.example.BatiCuisine.repositories.impl.MaterielRepositoryImpl;
import org.example.BatiCuisine.repositories.impl.ProjetRepositoryImpl;
import org.example.BatiCuisine.repositories.inter.ClientRepository;
import org.example.BatiCuisine.repositories.inter.MainDoeuvreRepository;
import org.example.BatiCuisine.repositories.inter.MaterielRepository;
import org.example.BatiCuisine.repositories.inter.ProjetRepository;
import org.example.BatiCuisine.services.impl.ClientServiceImpl;
import org.example.BatiCuisine.services.impl.MainDoeuvreServiceImpl;
import org.example.BatiCuisine.services.impl.MaterielServiceImpl;
import org.example.BatiCuisine.services.impl.ProjetServiceImpl;
import org.example.BatiCuisine.services.inter.ClientService;
import org.example.BatiCuisine.services.inter.MainDoeuvreService;
import org.example.BatiCuisine.services.inter.MaterielService;
import org.example.BatiCuisine.services.inter.ProjetService;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class MainView {

    private static final Scanner scanner = new Scanner(System.in);

    // Static service instances
    private static ProjetService projetService;
    private static ClientService clientService;
    private static MainDoeuvreService mainDoeuvreService;
    private static MaterielService materielService;

    public MainView() {
        // Connection
        Connection connection = Database.getInstance().getConnection();

        // Initialize static service instances
        projetService = createProjetService(connection);
        mainDoeuvreService = createMainDoeuvreService(connection);
        materielService = createMaterielService(connection);
        clientService = createClientService(connection);
    }

    private static ProjetService createProjetService(Connection connection) {
        ProjetDao projetDao = new ProjetDaoImpl(connection);
        ProjetRepository projetRepository = new ProjetRepositoryImpl(projetDao);
        return new ProjetServiceImpl(projetRepository);
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
                    for (Projet projet : projets) {
                        System.out.println(projet);
                    }
                    break;
                case 3:
                    System.out.println("Calculer le coût d'un projet en cours...");
                    // CalculView.calculerCoutProjet();
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
