package org.example.BatiCuisine.view;

import org.example.BatiCuisine.entities.Devis;
import org.example.BatiCuisine.entities.Projet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DevisView {

    private static final Scanner scanner = new Scanner(System.in);

    public static void enregistrerDevis(Projet projet) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("--- Enregistrement du Devis ---");

        try {
            System.out.println("Entrez la date d'émission du devis (format : jj/mm/aaaa) : ");
            String stringEmission = scanner.nextLine();
            Date dateEmission = formatter.parse(stringEmission);

            System.out.println("Entrez la date de validité du devis (format : jj/mm/aaaa) : ");
            String stringValidite = scanner.nextLine();
            Date dateValidite = formatter.parse(stringValidite);

            System.out.println("Souhaitez-vous enregistrer le devis ? (y/n) : y\n");
            String choix = scanner.nextLine().trim().toLowerCase();

            if(choix.equals("y")){
                Devis devis = new Devis(projet.getCoutTotal(),dateEmission,dateValidite,false,projet);
                MainView.getDevisService().ajouterDevis(devis);
            }else{
                System.out.println("Devis non enregistré");
                return;
            }

        } catch (ParseException e) {
            System.out.println("Format de date incorrect. Veuillez utiliser le format jj/mm/aaaa.");
        }


    }
}
