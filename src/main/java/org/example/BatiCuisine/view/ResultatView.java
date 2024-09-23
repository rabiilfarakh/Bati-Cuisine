package org.example.BatiCuisine.view;

import org.example.BatiCuisine.entities.MainDoeuvre;
import org.example.BatiCuisine.entities.Materiel;
import org.example.BatiCuisine.entities.Projet;
import org.example.BatiCuisine.util.ValidationUtil;

import java.util.List;
import java.util.Scanner;

public class ResultatView {

    private static final Scanner scanner = new Scanner(System.in);

    public static void result(Projet projet, List<Materiel> materiaux, List<MainDoeuvre> mainDoeuvres) {
        // Validation des entrées
        if (!ValidationUtil.estNomValide(projet.getNomProjet())) {
            System.out.println("Nom de projet invalide.");
            return;
        }
        if (projet.getClient() == null || !ValidationUtil.estNomValide(projet.getClient().getNom())) {
            System.out.println("Client invalide.");
            return;
        }

        System.out.println("--- Résultat du Calcul ---");
        System.out.println("Nom du projet : " + projet.getNomProjet());
        System.out.println("Client : " + projet.getClient().getNom());
        System.out.println("Adresse du chantier : " + projet.getClient().getAdresse());
        System.out.println("Surface : " + projet.getSurface());

        System.out.println("--- Détail des Coûts ---");
        System.out.println("1. Matériaux :");
        if (materiaux.isEmpty()) {
            System.out.println("Aucun matériau ajouté.");
        } else {
            materiaux.forEach(materiel -> System.out.println("- " + materiel.toString()));
        }

        // Calcul des coûts des matériaux
        double totalMateriaux = calculerCoutTotalMateriaux(materiaux);
        double totalMateriauxAvecTVA = calculerCoutTotalMateriauxAvecTVA(materiaux);

        System.out.println("**Coût total des matériaux avant TVA : " + totalMateriaux + " €**");
        System.out.println("**Coût total des matériaux avec TVA  : " + totalMateriauxAvecTVA + " €**");

        // Calcul des coûts de la main-d'œuvre
        System.out.println("2. Main-d'œuvre :");
        if (mainDoeuvres.isEmpty()) {
            System.out.println("Aucune main-d'œuvre ajoutée.");
        } else {
            mainDoeuvres.forEach(mainDoeuvre -> System.out.println("- " + mainDoeuvre.toString()));
        }

        double totalMainDoeuvre = calculerCoutTotalMainDoeuvre(mainDoeuvres);
        double totalMainDoeuvreAvecTVA = calculerCoutTotalMainDoeuvreAvecTVA(mainDoeuvres);

        System.out.println("**Coût total de la main-d'œuvre avant TVA : " + totalMainDoeuvre + " €**");
        System.out.println("**Coût total de la main-d'œuvre avec TVA  : " + totalMainDoeuvreAvecTVA + " €**");

        // Calcul final avec marge bénéficiaire
        double totalFinal = totalMateriauxAvecTVA + totalMainDoeuvreAvecTVA;
        double marge = calculerMarge(totalFinal, projet.getMargeBeneficiaire());
        double totalFinalAvecMarge = totalFinal + marge;

        System.out.println("3. Coût total avant marge: " + totalFinal + " €");
        System.out.println("4. Marge bénéficiaire (" + projet.getMargeBeneficiaire() + "%): " + marge + " €");
        System.out.println("**Coût total final du projet: " + totalFinalAvecMarge + " €**");

        DevisView.enregistrerDevis(projet);
    }

    // Fonction pour calculer le coût total des matériaux
    public static double calculerCoutTotalMateriaux(List<Materiel> materiaux) {
        return materiaux.stream()
                .mapToDouble(materiel -> (materiel.getQuantite() * materiel.getCoutUnitaire()) + materiel.getCoutTransport())
                .sum();
    }

    // Fonction pour calculer le coût total des matériaux avec TVA
    public static double calculerCoutTotalMateriauxAvecTVA(List<Materiel> materiaux) {
        return materiaux.stream()
                .mapToDouble(materiel -> {
                    double coutTotal = (materiel.getQuantite() * materiel.getCoutUnitaire()) + materiel.getCoutTransport();
                    double tva = coutTotal * (materiel.getTauxTVA() / 100);
                    return coutTotal + tva;
                })
                .sum();
    }

    // Fonction pour calculer le coût total de la main-d'œuvre
    public static double calculerCoutTotalMainDoeuvre(List<MainDoeuvre> mainDoeuvres) {
        return mainDoeuvres.stream()
                .mapToDouble(main -> (main.getHeuresTravail() * main.getTauxHoraire() * main.getProductiviteOuvrier()))
                .sum();
    }

    // Fonction pour calculer le coût total de la main-d'œuvre avec TVA
    public static double calculerCoutTotalMainDoeuvreAvecTVA(List<MainDoeuvre> mainDoeuvres) {
        return mainDoeuvres.stream()
                .mapToDouble(main -> {
                    double coutTotal = (main.getHeuresTravail() * main.getTauxHoraire() * main.getProductiviteOuvrier());
                    double tva = coutTotal * (main.getTauxTVA() / 100);
                    return coutTotal + tva;
                })
                .sum();
    }

    // Fonction pour calculer la marge bénéficiaire
    public static double calculerMarge(double total, double pourcentageMarge) {
        return ((total) * pourcentageMarge) / 100;
    }

    public static double calculerCoutTotalProjet(Projet projet, List<Materiel> materiels, List<MainDoeuvre> mainDoeuvres) {
        double totalMain = calculerCoutTotalMainDoeuvreAvecTVA(mainDoeuvres);
        double totalMateriaux = calculerCoutTotalMateriauxAvecTVA(materiels);
        double totale = totalMain + totalMateriaux;
        return totale + calculerMarge(totale, projet.getMargeBeneficiaire());
    }
}
