package org.example.BatiCuisine.view;

import org.example.BatiCuisine.entities.Client;
import org.example.BatiCuisine.entities.MainDoeuvre;
import org.example.BatiCuisine.entities.Materiel;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ResultatView {

    private static final Scanner scanner = new Scanner(System.in);

    public static void calculCoutTotal(Map<String, Client> client, Map<String, String> data, List<Materiel> materiaux, List<MainDoeuvre> mainDoeuvres) {
        Double marge = 0.0;
        Double tva = 0.0;

        System.out.println("--- Calcul du coût total ---\n");

        System.out.print("Souhaitez-vous appliquer une TVA au projet ? (y/n) : ");
        String reponseTVA = scanner.nextLine().trim().toLowerCase();

        if (reponseTVA.equals("y")) {
            System.out.print("Entrez le pourcentage de TVA (%) : ");
            try {
                tva = scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Pourcentage de TVA invalide. La TVA sera considérée comme 0.");
                tva = 0.0;
                scanner.nextLine();
            }
            scanner.nextLine();

            System.out.print("Souhaitez-vous appliquer une marge bénéficiaire au projet ? (y/n): ");
            String reponseMarge = scanner.nextLine().trim().toLowerCase();

            if (reponseMarge.equals("y")) {
                System.out.print("Entrez le pourcentage de marge bénéficiaire (%) : ");
                try {
                    marge = scanner.nextDouble();
                } catch (Exception e) {
                    System.out.println("Pourcentage de marge bénéficiaire invalide. La marge bénéficiaire sera considérée comme 0.");
                    marge = 0.0;
                    scanner.nextLine();
                }
                scanner.nextLine();
            }
        } else if (reponseTVA.equals("n")) {
            System.out.print("Souhaitez-vous appliquer une marge bénéficiaire au projet ? (y/n): ");
            String reponseMarge = scanner.nextLine().trim().toLowerCase();

            if (reponseMarge.equals("y")) {
                System.out.print("Entrez le pourcentage de marge bénéficiaire (%) : ");
                try {
                    marge = scanner.nextDouble();
                } catch (Exception e) {
                    System.out.println("Pourcentage de marge bénéficiaire invalide. La marge bénéficiaire sera considérée comme 0.");
                    marge = 0.0;
                    scanner.nextLine();
                }
                scanner.nextLine();
            }
        } else {
            System.out.println("Réponse invalide. La TVA et la marge bénéficiaire seront considérées comme 0.");
        }

        data.put("tva",String.valueOf(tva));
        data.put("marge",String.valueOf(tva));

        System.out.println("Calcul du coût en cours...");
        result(client, data, materiaux, mainDoeuvres);
    }


    public static void result(Map<String, Client> client, Map<String,String> data, List<Materiel> materiaux, List<MainDoeuvre> mainDoeuvres){

        System.out.println("--- Résultat du Calcul ---");
        System.out.println("Nom du projet : " + data.get("nomProjet"));
        System.out.println("Client : " + client.get("nom"));
        System.out.println("Adresse du chantier : " + client.get("adresse"));
        System.out.println("Surface : " + data.get("surface"));

        System.out.println("--- Détail des Coûts ---");
        System.out.println("1. Matériaux :");

        //afficher les materiaux
        materiaux.stream()
                .forEach(materiel -> System.out.println("- " + materiel.toString()));

        //afficher les mainDoeuvres
        System.out.println("2. Main-d'œuvre :");
        mainDoeuvres.stream()
                .forEach(mainDoeuvre -> System.out.println("- " + mainDoeuvre.toString()));


        System.out.println("3. Coût total avant marge : En cours");
    }
}
