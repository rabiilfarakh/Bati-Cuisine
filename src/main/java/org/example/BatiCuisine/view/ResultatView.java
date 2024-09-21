package org.example.BatiCuisine.view;

import org.example.BatiCuisine.entities.MainDoeuvre;
import org.example.BatiCuisine.entities.Materiel;
import org.example.BatiCuisine.entities.Projet;

import java.util.List;
import java.util.Scanner;

public class ResultatView {

    private static final Scanner scanner = new Scanner(System.in);

    public static void result(Projet projet, List<Materiel> materiaux, List<MainDoeuvre> mainDoeuvres){

        System.out.println("--- Résultat du Calcul ---");
        System.out.println("Nom du projet : " + projet.getNomProjet());
        System.out.println("Client : " + projet.getClient().getNom());
        System.out.println("Adresse du chantier : " + projet.getClient().getAdresse());
        System.out.println("Surface : " + projet.getSurface());

        System.out.println("--- Détail des Coûts ---");
        System.out.println("1. Matériaux :");

        //afficher les materiaux
        materiaux.stream()
                .forEach(materiel -> System.out.println("- " + materiel.toString()));

        double total = materiaux.stream()
                .mapToDouble(materiel -> (materiel.getQuantite() * materiel.getCoutUnitaire())+materiel.getCoutTransport())
                .sum();

        double totalAvecTva = materiaux.stream()
                .mapToDouble(materiel -> {
                    double coutTotal = (materiel.getQuantite() * materiel.getCoutUnitaire()) + materiel.getCoutTransport();
                    double tva = coutTotal * (materiel.getTauxTVA() / 100);
                    return coutTotal + tva;
                })
                .sum();

        System.out.println("**Coût total des matériaux avant TVA : " + total + " €**");
        System.out.println("**Coût total des matériaux avec TVA  : " + totalAvecTva + " €**");


        //afficher les mainDoeuvres
        System.out.println("2. Main-d'œuvre :");
        mainDoeuvres.stream()
                .forEach(mainDoeuvre -> System.out.println("- " + mainDoeuvre.toString()));

        double totalMainDoeuvre = mainDoeuvres.stream()
                .mapToDouble(main -> (main.getHeuresTravail()*main.getTauxHoraire()*main.getProductiviteOuvrier()))
                .sum();

        double totalMainDoeuvreAvecTva = mainDoeuvres.stream()
                .mapToDouble(main -> {
                    double coutTotal = (main.getHeuresTravail()*main.getTauxHoraire()*main.getProductiviteOuvrier());
                    double tva = coutTotal * (main.getTauxTVA() / 100);
                    return coutTotal + tva;
                })
                .sum();

        System.out.println("**Coût total de la main-d'œuvre avant TVA : " + totalMainDoeuvre + " €**");
        System.out.println("**Coût total de la main-d'œuvre avec TVA  : " + totalMainDoeuvreAvecTva + " €**");

        double totaleFinale = totalMainDoeuvreAvecTva + totalAvecTva;
        double marge = ( (totaleFinale * projet.getMargeBeneficiaire()) / 100);
        double totaleMarge = totaleFinale + marge;

        System.out.println("3. Coût total avant marge: " + totaleFinale + " €");
        System.out.println("4. Marge bénéficiaire ("+projet.getMargeBeneficiaire()+"%): "+marge+" €");
        System.out.println("**Coût total final du projet: "+totaleMarge+" €");

    }
}
