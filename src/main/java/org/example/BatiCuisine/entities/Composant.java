package org.example.BatiCuisine.entities;

import org.example.BatiCuisine.enums.TypeComposant;

public class Composant {

    private Integer id;
    private String nom;
    private double tauxTVA;
    private TypeComposant typeComposant;
    private Projet projet;

    // Constructeur
    public Composant(String nom, double tauxTVA, TypeComposant typeComposant, Projet projet) {
        this.nom = nom;
        this.tauxTVA = tauxTVA;
        this.typeComposant = typeComposant;
        this.projet = projet;
    }

    // Constructeur sans parametres
    public Composant() {
        ;
    }

    // Constructeur unique
    public Composant(String nom) {
        this.nom = nom;
    }

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getTauxTVA() {
        return tauxTVA;
    }

    public void setTauxTVA(double tauxTVA) {
        this.tauxTVA = tauxTVA;
    }

    public TypeComposant getTypeComposant() {
        return typeComposant;
    }

    public void setTypeComposant(TypeComposant typeComposant) {
        this.typeComposant = typeComposant;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    @Override
    public String toString() {
        return "Composant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", tauxTVA=" + tauxTVA +
                ", typeComposant=" + typeComposant +
                ", projet=" + projet +
                '}';
    }
}

