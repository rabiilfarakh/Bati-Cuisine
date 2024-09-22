package org.example.BatiCuisine.view;

import org.example.BatiCuisine.entities.Client;
import org.example.BatiCuisine.entities.MainDoeuvre;
import org.example.BatiCuisine.entities.Materiel;
import org.example.BatiCuisine.entities.Projet;
import org.example.BatiCuisine.services.inter.MainDoeuvreService;
import org.example.BatiCuisine.services.inter.MaterielService;
import org.example.BatiCuisine.services.inter.ProjetService;

import java.util.*;

import static org.example.BatiCuisine.enums.EtatProjet.EN_COURS;
import static org.example.BatiCuisine.view.ResultatView.result;

public class ProjetView {
    private static final Scanner scanner = new Scanner(System.in);

    public static void creerProjet(Projet projet) {
        System.out.println("--- Création d'un Nouveau Projet ---");
        System.out.print("Entrez le nom du projet : ");
        String nomProjet = scanner.nextLine();
        System.out.print("Entrez la surface de la cuisine (en m²) : ");
        double surface = scanner.nextDouble();
        scanner.nextLine();

        projet.setNomProjet(nomProjet);
        projet.setSurface(surface);

        List<Materiel> materiels = ComposantView.ajouterComposants(projet);
        List<MainDoeuvre> mainDoeuvres = ComposantView.ajouterMainDoeuvre(projet);

        System.out.println("--- Calcul du coût total ---\n");

        System.out.print("Souhaitez-vous appliquer une marge bénéficiaire au projet ? (y/n): ");
        String reponseMarge = scanner.nextLine().trim().toLowerCase();

        if (reponseMarge.equals("y")) {
            System.out.print("Entrez le pourcentage de marge bénéficiaire (%) : ");
            try {
                double marge = scanner.nextDouble();
                projet.setMargeBeneficiaire(marge);
            } catch (InputMismatchException e) {
                System.out.println("Pourcentage de marge bénéficiaire invalide. La marge bénéficiaire sera considérée comme 0.");
                scanner.nextLine();
            }
            scanner.nextLine();
        } else if (reponseMarge.equals("n")) {
            System.out.println("Aucune marge bénéficiaire ne sera appliquée.");
        } else {
            System.out.println("Réponse invalide. La marge bénéficiaire sera considérée comme 0.");
        }


        projet.setEtatProjet(EN_COURS);
        projet.setId(MainView.getProjetService().ajouterProjet(projet,projet.getClient().getId())) ;

        // insert mainDoeuvre
        for (MainDoeuvre mainDoeuvre : mainDoeuvres) {
            MainView.getMainDoeuvreService().ajouterMainDoeuvre(mainDoeuvre);
        }

        // insert materiaux
        for (Materiel materiel : materiels) {
            MainView.getMaterielService().ajouterMateriel(materiel);
        }

        System.out.println("Calcul du coût en cours ...");
        result(projet, materiels, mainDoeuvres);
    }
}
