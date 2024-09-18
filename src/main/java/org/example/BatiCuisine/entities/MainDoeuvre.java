package org.example.BatiCuisine.entities;

import org.example.BatiCuisine.enums.TypeComposant;

public class MainDoeuvre extends Composant {

    private double tauxHoraire;
    private double heuresTravail;
    private double productiviteOuvrier;

    // Constructeur
    public MainDoeuvre(Integer id, String nom, double tauxTVA, TypeComposant typeComposant, Projet projet, double tauxHoraire, double heuresTravail, double productiviteOuvrier) {
        super(id, nom, tauxTVA, typeComposant, projet);
        this.tauxHoraire = tauxHoraire;
        this.heuresTravail = heuresTravail;
        this.productiviteOuvrier = productiviteOuvrier;
    }

    // Getters et Setters
    public double getTauxHoraire() {
        return tauxHoraire;
    }

    public void setTauxHoraire(double tauxHoraire) {
        this.tauxHoraire = tauxHoraire;
    }

    public double getHeuresTravail() {
        return heuresTravail;
    }

    public void setHeuresTravail(double heuresTravail) {
        this.heuresTravail = heuresTravail;
    }

    public double getProductiviteOuvrier() {
        return productiviteOuvrier;
    }

    public void setProductiviteOuvrier(double productiviteOuvrier) {
        this.productiviteOuvrier = productiviteOuvrier;
    }
}

