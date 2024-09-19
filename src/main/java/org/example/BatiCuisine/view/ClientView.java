package org.example.BatiCuisine.view;

import org.example.BatiCuisine.config.Database;
import org.example.BatiCuisine.dao.impl.ClientDaoImpl;
import org.example.BatiCuisine.dao.inter.ClientDao;
import org.example.BatiCuisine.entities.Client;

import java.sql.Connection;
import java.util.*;

public class ClientView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Client> clients = new ArrayList<>();

    private static final Connection connection = Database.getInstance().getConnection();
    private static final ClientDao clientDao = new ClientDaoImpl(connection);

    public static Client rechercherOuAjouterClient() {
        System.out.println("--- Recherche de client ---");
        System.out.println("Souhaitez-vous chercher un client existant ou en ajouter un nouveau ?");
        System.out.println("1. Chercher un client existant");
        System.out.println("2. Ajouter un nouveau client");
        System.out.print("Choisissez une option : ");

        int choix;
        try {
            choix = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Option invalide. Veuillez entrer un nombre.");
            scanner.nextLine();
            return null;
        }

        switch (choix) {
            case 1:
                rechercherClientEtContinuer();
                return null;
            case 2:
                return ajouterClient();
            default:
                System.out.println("Option invalide.");
                return null;
        }
    }

    private static void rechercherClientEtContinuer() {
        System.out.println("--- Recherche de client existant ---");
        System.out.print("Entrez le nom du client : ");
        String nom = scanner.nextLine();
        List<Client> clientsTrouves = rechercherClient(nom);

        if (clientsTrouves.isEmpty()) {
            System.out.println("Client non trouvé.");
        } else {
            System.out.println("Clients trouvés :");
            clientsTrouves.forEach(client -> System.out.println(client));
            System.out.println("Souhaitez-vous continuer avec ce client ? (y/n) : ");
            String reponse = scanner.nextLine().trim().toLowerCase();

            if (reponse.equals("y")) {
                ProjetView.creerProjet(clientsTrouves);
            }
        }
    }

    private static List<Client> rechercherClient(String nom) {
        return clientDao.chercherClient(nom);
    }

    private static Client ajouterClient() {
        System.out.print("Entrez le nom du client : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez l'adresse du client : ");
        String adresse = scanner.nextLine();
        System.out.print("Entrez le numéro de téléphone : ");
        String telephone = scanner.nextLine();
        System.out.print("Le client est-il un professionnel ? (true/false) : ");
        boolean estProfessionnel;
        try {
            estProfessionnel = scanner.nextBoolean();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Réponse invalide. La valeur par défaut sera false.");
            estProfessionnel = false;
            scanner.nextLine();
        }

        Client client = new Client(nom, adresse, telephone, estProfessionnel);
        clientDao.ajouterClient(client);

        System.out.println("Client ajouté avec succès !");
        return client;
    }
}
