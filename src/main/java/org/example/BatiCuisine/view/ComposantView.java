package org.example.BatiCuisine.view;

import org.example.BatiCuisine.entities.MainDoeuvre;
import org.example.BatiCuisine.entities.Materiel;
import org.example.BatiCuisine.entities.Projet;
import org.example.BatiCuisine.enums.TypeComposant;

import java.util.*;

public class ComposantView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<MainDoeuvre> ajouterMainDoeuvre(Projet projet){

        List<MainDoeuvre> mainDoeuvres = new ArrayList<>();

        System.out.println("--- Ajout de la main-d'œuvre ---");
        while (true) {
            System.out.print("Entrez le type de main-d'œuvre (e.g., Ouvrier de base, Spécialiste) : ");
            String nomMainDoeuvre = scanner.nextLine();

            System.out.print("Entrez le taux horaire de cette main-d'œuvre (€/h) : ");
            double tauxHoraire = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Entrez le nombre d'heures travaillées : ");
            Integer nbrHeures = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Entrez le facteur de productivité (1.0 = standard, > 1.0 = haute productivité) : ");
            double facteurProd = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Entrez TVA : ");
            double tva = scanner.nextDouble();
            scanner.nextLine();

            MainDoeuvre mainDoeuvre = new MainDoeuvre(nomMainDoeuvre,tva,TypeComposant.MAIN_D_OEUVRE,projet,tauxHoraire, nbrHeures, facteurProd);

            if(mainDoeuvres.add(mainDoeuvre)){
                System.out.println("Main-d'œuvre ajoutée avec succès !");
            }else{
                System.out.println("Probléme d'ajout de Main-d'œuvre");
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
            System.out.print("Entrez le nom du matériau : ");
            String nomMateril = scanner.nextLine();
            System.out.print("Entrez la quantité de ce matériau : ");
            double quantite = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Entrez le coût unitaire de ce matériau : ");
            double coutUnitaire = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Entrez le coût de transport de ce matériau : ");
            double coutTransport = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Entrez le coefficient de qualité (1.0 = standard, > 1.0 = haute qualité) : ");
            double coefficientQualite = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Entrez TVA : ");
            double tva = scanner.nextDouble();
            scanner.nextLine();

            Materiel materiel = new Materiel(nomMateril, tva, TypeComposant.MATERIAUX ,projet,quantite, coutUnitaire, coutTransport, coefficientQualite);

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
