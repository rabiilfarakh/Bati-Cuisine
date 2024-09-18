package org.example.BatiCuisine.view;

import org.example.BatiCuisine.entities.Materiel;
import org.example.BatiCuisine.entities.Projet;

import java.util.Scanner;

public class ComposantView {
    private static final Scanner scanner = new Scanner(System.in);

    public static void ajouterComposants(Projet projet) {
        System.out.println("--- Ajout des matériaux ---");
        while (true) {
            System.out.print("Entrez le nom du matériau : ");
            String nomMateriau = scanner.nextLine();
            System.out.print("Entrez la quantité de ce matériau : ");
            double quantite = scanner.nextDouble();
            System.out.print("Entrez le coût unitaire de ce matériau : ");
            double coutUnitaire = scanner.nextDouble();
            System.out.print("Entrez le coût de transport de ce matériau : ");
            double coutTransport = scanner.nextDouble();
            System.out.print("Entrez le coefficient de qualité (1.0 = standard, > 1.0 = haute qualité) : ");
            double coefficientQualite = scanner.nextDouble();
            scanner.nextLine();

            //Materiel materiau = new Materiel(nomMateriau, quantite, coutUnitaire, coutTransport, coefficientQualite);
            //projet.ajouterComposant(materiau);

            System.out.print("Voulez-vous ajouter un autre matériau ? (y/n) : ");
            if (scanner.nextLine().equalsIgnoreCase("n")) {
                break;
            }
        }
    }
}
