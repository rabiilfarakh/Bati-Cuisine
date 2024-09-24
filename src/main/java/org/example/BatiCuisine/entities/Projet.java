package org.example.BatiCuisine.entities;

import org.example.BatiCuisine.enums.EtatProjet;

import java.util.List;

public class Projet {
    private Integer id;
    private String nomProjet;
    private double margeBeneficiaire;
    private double coutTotal;
    private double surface;
    private EtatProjet etatProjet;
    private Client client;
    private List<Materiel> materiels;
    private List<MainDoeuvre> mainDoeuvres;


    public Projet(String nomProjet, double margeBeneficiaire, double coutTotal, double surface, EtatProjet etatProjet, Client client) {
        this.nomProjet = nomProjet;
        this.margeBeneficiaire = margeBeneficiaire;
        this.coutTotal = coutTotal;
        this.surface = surface;
        this.etatProjet = etatProjet;
        this.client = client;
    }

    public Projet(Integer id, String nomProjet, double margeBeneficiaire, double coutTotal, double surface, EtatProjet etatProjet, Client client) {
        this.id = id;
        this.nomProjet = nomProjet;
        this.margeBeneficiaire = margeBeneficiaire;
        this.coutTotal = coutTotal;
        this.surface = surface;
        this.etatProjet = etatProjet;
        this.client = client;
    }

    public Projet(){}

    public Projet(Integer id, String nomProjet, double margeBeneficiaire, double coutTotal, double surface, EtatProjet etatProjet, Client client, List<Materiel> materiels, List<MainDoeuvre> mainDoeuvres) {
        this.id = id;
        this.nomProjet = nomProjet;
        this.margeBeneficiaire = margeBeneficiaire;
        this.coutTotal = coutTotal;
        this.surface = surface;
        this.etatProjet = etatProjet;
        this.client = client;
        this.materiels = materiels;
        this.mainDoeuvres = mainDoeuvres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public double getMargeBeneficiaire() {
        return margeBeneficiaire;
    }

    public void setMargeBeneficiaire(double margeBeneficiaire) {
        this.margeBeneficiaire = margeBeneficiaire;
    }

    public double getCoutTotal() {
        return coutTotal;
    }

    public void setCoutTotal(double coutTotal) {
        this.coutTotal = coutTotal;
    }

    public double getSurface() {
        return surface;
    }

    public void setSurface(double surface) {
        this.surface = surface;
    }

    public EtatProjet getEtatProjet() {
        return etatProjet;
    }

    public void setEtatProjet(EtatProjet etatProjet) {
        this.etatProjet = etatProjet;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }



    @Override
    public String toString() {
        return String.format(
                "+---------------+-------------------+------------------------+-------------------+---------+---------------------+------------+----------------+\n" +
                        "| ID Projet     | Nom du Client     | Adresse                | Nom du Projet     | Surface | Marge Bénéficiaire  | Coût Total | État du Projet |\n" +
                        "+---------------+-------------------+------------------------+-------------------+---------+---------------------+------------+----------------+\n" +
                        "| %-13s | %-17s | %-22s | %-17s | %-7.2f | %-19.2f | %-10.2f | %-14s |\n" +
                        "+---------------+-------------------+------------------------+-------------------+---------+---------------------+------------+----------------+\n",
                id,
                client.getNom(),
                client.getAdresse(),
                nomProjet,
                surface,
                margeBeneficiaire,
                coutTotal,
                etatProjet
        );
    }


    public List<Materiel> getMateriels() {
        return materiels;
    }

    public void setMateriels(List<Materiel> materiels) {
        this.materiels = materiels;
    }

    public List<MainDoeuvre> getMainDoeuvres() {
        return mainDoeuvres;
    }

    public void setMainDoeuvres(List<MainDoeuvre> mainDoeuvres) {
        this.mainDoeuvres = mainDoeuvres;
    }



    public static void afficherDetailsProjet(Projet projet) {
        if (projet == null) {
            System.out.println("Aucun projet à afficher.");
            return;
        }

        System.out.println("--- Résultat du Calcul ---");
        System.out.printf("Nom du projet : %s%n", projet.getNomProjet());
        System.out.printf("Client : %s%n", projet.getClient().getNom());
        System.out.printf("Surface : %.2f m²%n", projet.getSurface());

        // Matériaux
        System.out.println("--- Détail des Coûts ---");
        System.out.println("1. Matériaux :");
        double totalMateriaux = 0.0;

        for (Materiel materiel : projet.getMateriels()) {
            double coutMateriel = materiel.getCoutUnitaire() * materiel.getQuantite();
            totalMateriaux += coutMateriel;
            System.out.printf("- %s : %.2f € (quantité : %.0f, coût unitaire : %.2f €/unité, transport : %.2f €)%n",
                    materiel.getNom(),
                    coutMateriel,
                    materiel.getQuantite(),
                    materiel.getCoutUnitaire(),
                    materiel.getCoutTransport());
        }

        double tvaMateriaux = totalMateriaux * 0.20;
        System.out.printf("**Coût total des matériaux avant TVA : %.2f €**%n", totalMateriaux);
        System.out.printf("**Coût total des matériaux avec TVA (20%%) : %.2f €**%n", totalMateriaux + tvaMateriaux);

        // Main-d'œuvre
        System.out.println("2. Main-d'œuvre :");
        double totalMainDoeuvre = 0.0;

        for (MainDoeuvre mainDoeuvre : projet.getMainDoeuvres()) {
            double coutMainDoeuvre = mainDoeuvre.getTauxHoraire() * mainDoeuvre.getHeuresTravail();
            totalMainDoeuvre += coutMainDoeuvre;
            System.out.printf("- %s : %.2f € (taux horaire : %.2f €/h, heures travaillées : %.2f h)%n",
                    mainDoeuvre.getNom(),
                    coutMainDoeuvre,
                    mainDoeuvre.getTauxHoraire(),
                    mainDoeuvre.getHeuresTravail());
        }

        double tvaMainDoeuvre = totalMainDoeuvre * 0.20;
        System.out.printf("**Coût total de la main-d'œuvre avant TVA : %.2f €**%n", totalMainDoeuvre);
        System.out.printf("**Coût total de la main-d'œuvre avec TVA (20%%) : %.2f €**%n", totalMainDoeuvre + tvaMainDoeuvre);

        // Coût total
        double coutTotalAvantMarge = totalMateriaux + totalMainDoeuvre;
        double margeBeneficiaire = projet.getMargeBeneficiaire() / 100 * coutTotalAvantMarge;
        double coutTotalFinal = coutTotalAvantMarge + margeBeneficiaire;

        System.out.printf("3. Coût total avant marge : %.2f €%n", coutTotalAvantMarge);
        System.out.printf("4. Marge bénéficiaire (%.2f%%) : %.2f €%n", projet.getMargeBeneficiaire(), margeBeneficiaire);
        System.out.printf("**Coût total final du projet : %.2f €**%n", coutTotalFinal);
    }





}



