package org.example.BatiCuisine.view;

import org.example.BatiCuisine.entities.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Client> clients = new ArrayList<>();

    public static Client rechercherOuAjouterClient() {
        System.out.println("--- Recherche de client ---");
        System.out.println("1. Chercher un client existant");
        System.out.println("2. Ajouter un nouveau client");
        System.out.print("Choisissez une option : ");
        int choix = scanner.nextInt();
        scanner.nextLine();

        if (choix == 1) {
            return rechercherClient();
        } else if (choix == 2) {
            return ajouterClient();
        } else {
            System.out.println("Option invalide.");
            return null;
        }
    }

    private static Client rechercherClient() {
        System.out.println("--- Recherche de client existant ---");
        System.out.print("Entrez le nom du client : ");
        String nom = scanner.nextLine();
        // appler la methode chercherClient
        //System.out.println("Client trouvé !");
        System.out.println("Client non trouvé.");
        return null;
    }

    private static Client ajouterClient() {
        System.out.print("Entrez le nom du client : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez l'adresse du client : ");
        String adresse = scanner.nextLine();
        System.out.print("Entrez le numéro de téléphone : ");
        String telephone = scanner.nextLine();
        System.out.print("Le client est-il un professionnel ? (true/false) : ");
        boolean estProfessionnel = scanner.nextBoolean();

        //Client client = new Client(nom, adresse, telephone, estProfessionnel);
        //clients.add(client);
        System.out.println("Client ajouté avec succès !");
        return null ;//client;
    }

    private static void afficherClient(Client client) {
        System.out.println("Nom : " + client.getNom());
        System.out.println("Adresse : " + client.getAdresse());
        System.out.println("Téléphone : " + client.getTelephone());
        System.out.println("Professionnel : " + (client.isEstProfessionnel() ? "Oui" : "Non"));
    }
}

