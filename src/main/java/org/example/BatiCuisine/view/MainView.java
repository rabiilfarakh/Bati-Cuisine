package org.example.BatiCuisine.view;

import java.util.Scanner;

public class MainView {
    private static final Scanner scanner = new Scanner(System.in);

    public static void view() {
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
                    System.out.println("affichage des projet en cours a realiser ...");
                    //ProjetView.afficherProjets();
                    break;
                case 3:
                    System.out.println("Calculer le coût d'un projet en cours a realiser ...");
                    //CalculView.calculerCoutProjet();
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
}

