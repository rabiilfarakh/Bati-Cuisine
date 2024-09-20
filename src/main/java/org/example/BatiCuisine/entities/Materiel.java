package org.example.BatiCuisine.entities;

import org.example.BatiCuisine.enums.TypeComposant;

public class Materiel extends Composant {

    private double coutUnitaire;
    private double quantite;
    private double coutTransport;
    private double coefficientQualite;

    // Constructeur
    public Materiel(String nom, double tauxTVA, TypeComposant typeComposant, Projet projet, double coutUnitaire, double quantite, double coutTransport, double coefficientQualite) {
        super(nom, tauxTVA, typeComposant, projet);
        this.coutUnitaire = coutUnitaire;
        this.quantite = quantite;
        this.coutTransport = coutTransport;
        this.coefficientQualite = coefficientQualite;
    }

    // Constructeur sans unique
    public Materiel(String nom, double quantite, double coutUnitaire, double coutTransport, double coefficientQualite) {
        super(nom);
        this.coutUnitaire = coutUnitaire;
        this.quantite = quantite;
        this.coutTransport = coutTransport;
        this.coefficientQualite = coefficientQualite;
    }

    // Constructeur sans parametres
    public Materiel() {
    }

    // Getters et Setters
    public double getCoutUnitaire() {
        return coutUnitaire;
    }

    public void setCoutUnitaire(double coutUnitaire) {
        this.coutUnitaire = coutUnitaire;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public double getCoutTransport() {
        return coutTransport;
    }

    public void setCoutTransport(double coutTransport) {
        this.coutTransport = coutTransport;
    }

    public double getCoefficientQualite() {
        return coefficientQualite;
    }

    public void setCoefficientQualite(double coefficientQualite) {
        this.coefficientQualite = coefficientQualite;
    }

    @Override
    public String toString() {
        return "Materiel{" +
                "coutUnitaire=" + coutUnitaire +
                ", quantite=" + quantite +
                ", coutTransport=" + coutTransport +
                ", coefficientQualite=" + coefficientQualite +
                '}';
    }
}

