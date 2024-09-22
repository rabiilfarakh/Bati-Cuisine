package org.example.BatiCuisine.view;

import org.example.BatiCuisine.entities.Client;
import org.example.BatiCuisine.entities.Projet;
import org.example.BatiCuisine.services.inter.ClientService;
import java.util.*;

public class ClientView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Client> clients = new ArrayList<>();


    public static Client rechercherOuAjouterClient(ClientService clientService) {
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
                rechercherClientEtContinuer(clientService);
                return null;
            case 2:
                return ajouterClient(clientService);
            default:
                System.out.println("Option invalide.");
                return null;
        }
    }

    private static void rechercherClientEtContinuer(ClientService clientService) {
        System.out.println("--- Recherche de client existant ---");
        System.out.print("Entrez le nom du client : ");
        String nom = scanner.nextLine();

        List<Client> clientsTrouves = rechercherClient(clientService,nom);

        if (clientsTrouves.isEmpty()) {
            System.out.println("Client non trouvé.");
        } else {
            System.out.println("Clients trouvés :");
            for (Client client : clientsTrouves) {
                System.out.println(client);
            }

            System.out.print("Souhaitez-vous continuer avec l'un de ces clients ? (y/n) : ");
            String reponse = scanner.nextLine().trim().toLowerCase();

            if (reponse.equals("y")) {

                Client clientChoisi = clientsTrouves.get(0);
                Projet projet = new Projet();
                projet.setClient(clientChoisi);

                ProjetView.creerProjet(projet);
            }
        }
    }


    private static List<Client> rechercherClient(ClientService clientService , String nom) {
        return clientService.chercherClient(nom);
    }

    private static Client ajouterClient(ClientService clientService) {
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
        clientService.ajouterClient(client);

        System.out.println("Client ajouté avec succès !");
        return client;
    }
}
