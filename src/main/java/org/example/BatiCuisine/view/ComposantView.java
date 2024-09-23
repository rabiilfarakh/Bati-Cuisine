package org.example.BatiCuisine.view;

import org.example.BatiCuisine.entities.MainDoeuvre;
import org.example.BatiCuisine.entities.Materiel;
import org.example.BatiCuisine.entities.Projet;
import org.example.BatiCuisine.enums.TypeComposant;
import org.example.BatiCuisine.util.ValidationUtil;

import java.util.*;

public class ComposantView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<MainDoeuvre> ajouterMainDoeuvre(Projet projet) {
        List<MainDoeuvre> mainDoeuvres = new ArrayList<>();

        System.out.println("--- Ajout de la main-d'œuvre ---");
        while (true) {
            String nomMainDoeuvre;
            double tauxHoraire, facteurProd, tva;
            Integer nbrHeures;

            do {
                System.out.print("Entrez le type de main-d'œuvre : ");
                nomMainDoeuvre = scanner.nextLine();
            } while (!ValidationUtil.estNomValide(nomMainDoeuvre));

            do {
                System.out.print("Entrez le taux horaire de cette main-d'œuvre (€/h) : ");
                tauxHoraire = scanner.nextDouble();
                scanner.nextLine();
            } while (!ValidationUtil.estTauxHoraireValide(tauxHoraire));

            do {
                System.out.print("Entrez le nombre d'heures travaillées : ");
                nbrHeures = scanner.nextInt();
                scanner.nextLine();
            } while (nbrHeures == null || nbrHeures <= 0);

            do {
                System.out.print("Entrez le facteur de productivité : ");
                facteurProd = scanner.nextDouble();
                scanner.nextLine();
            } while (facteurProd <= 0);

            do {
                System.out.print("Entrez TVA : ");
                tva = scanner.nextDouble();
                scanner.nextLine();
            } while (tva < 0);

            MainDoeuvre mainDoeuvre = new MainDoeuvre(nomMainDoeuvre, tva, TypeComposant.MAIN_D_OEUVRE, projet, tauxHoraire, nbrHeures, facteurProd);

            if (mainDoeuvres.add(mainDoeuvre)) {
                System.out.println("Main-d'œuvre ajoutée avec succès !");
            } else {
                System.out.println("Problème d'ajout de Main-d'œuvre");
            }

            System.out.print("Voulez-vous ajouter un autre type de main-d'œuvre ? (y/n) : ");
            if (scanner.nextLine().equalsIgnoreCase("n")) {
                return mainDoeuvres;
            }
        }
    }

    public static List<Materiel> ajouterComposants(Projet projet) {
        List<Materiel> materiaux = new ArrayList<>();

        System.out.println("--- Ajout des matériaux ---");
        while (true) {
            String nomMateriel;
            double quantite, coutUnitaire, coutTransport, coefficientQualite, tva;

            do {
                System.out.print("Entrez le nom du matériau : ");
                nomMateriel = scanner.nextLine();
            } while (!ValidationUtil.estNomValide(nomMateriel));

            do {
                System.out.print("Entrez la quantité de ce matériau : ");
                quantite = scanner.nextDouble();
                scanner.nextLine();
            } while (!ValidationUtil.estQuantiteValide(quantite));

            do {
                System.out.print("Entrez le coût unitaire de ce matériau : ");
                coutUnitaire = scanner.nextDouble();
                scanner.nextLine();
            } while (coutUnitaire < 0);

            do {
                System.out.print("Entrez le coût de transport de ce matériau : ");
                coutTransport = scanner.nextDouble();
                scanner.nextLine();
            } while (coutTransport < 0);

            do {
                System.out.print("Entrez le coefficient de qualité : ");
                coefficientQualite = scanner.nextDouble();
                scanner.nextLine();
            } while (coefficientQualite <= 0);

            do {
                System.out.print("Entrez TVA : ");
                tva = scanner.nextDouble();
                scanner.nextLine();
            } while (tva < 0);

            Materiel materiel = new Materiel(nomMateriel, tva, TypeComposant.MATERIAUX, projet, quantite, coutUnitaire, coutTransport, coefficientQualite);

            if (materiaux.add(materiel)) {
                System.out.println("Matériau ajouté avec succès !");
            } else {
                System.out.println("Problème d'ajout de Matériel");
            }

            System.out.print("Voulez-vous ajouter un autre matériau ? (y/n) : ");
            if (scanner.nextLine().equalsIgnoreCase("n")) {
                return materiaux;
            }
        }
    }
}
