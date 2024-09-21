package org.example.BatiCuisine.view;

import org.example.BatiCuisine.entities.Client;
import org.example.BatiCuisine.entities.MainDoeuvre;
import org.example.BatiCuisine.entities.Materiel;
import org.example.BatiCuisine.entities.Projet;

import java.util.List;
import java.util.Map;
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

        //afficher les mainDoeuvres
        System.out.println("2. Main-d'œuvre :");
        mainDoeuvres.stream()
                .forEach(mainDoeuvre -> System.out.println("- " + mainDoeuvre.toString()));


        System.out.println("3. Coût total avant marge : En cours");
    }
}
