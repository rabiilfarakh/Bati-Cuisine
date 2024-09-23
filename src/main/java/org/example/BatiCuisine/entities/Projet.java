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
                "+-------------------+------------------------+-------------------+---------+---------------------+------------+----------------+\n" +
                        "| Nom du Client     | Adresse                | Nom du Projet     | Surface | Marge Bénéficiaire  | Coût Total | État du Projet |\n" +
                        "+-------------------+------------------------+-------------------+---------+---------------------+------------+----------------+\n" +
                        "| %-17s | %-22s | %-17s | %-7.2f | %-19.2f | %-10.2f | %-14s |\n" +
                        "+-------------------+------------------------+-------------------+---------+---------------------+------------+----------------+\n",
                client.getNom(),
                client.getAdresse(),
                nomProjet,
                surface,
                margeBeneficiaire,
                coutTotal,
                etatProjet
        );
    }


    }



