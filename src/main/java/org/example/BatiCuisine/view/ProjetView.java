package org.example.BatiCuisine.view;

import org.example.BatiCuisine.entities.Client;
import org.example.BatiCuisine.entities.Projet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjetView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Projet> projets = new ArrayList<>();

    public static void creerProjet() {
        System.out.println("--- Création d'un Nouveau Projet ---");
        Client client = ClientView.rechercherOuAjouterClient();
        if (client != null) {
            System.out.print("Entrez le nom du projet : ");
            String nomProjet = scanner.nextLine();
            System.out.print("Entrez la marge bénéficiaire (%) : ");
            double margeBeneficiaire = scanner.nextDouble();

            //Projet projet = new Projet(nomProjet, margeBeneficiaire, client);
            //projets.add(projet);

            System.out.println("Projet créé avec succès !");
            //ComposantView.ajouterComposants(projet);
        }
    }

    public static void afficherProjets() {
        if (projets.isEmpty()) {
            System.out.println("Aucun projet n'est enregistré.");
        } else {
            for (Projet projet : projets) {
                System.out.println("Projet : " + projet.getNomProjet() + " - Coût total : " + projet.getCoutTotal());
            }
        }
    }
}

