package org.example.BatiCuisine.view;

import org.example.BatiCuisine.entities.Client;
import org.example.BatiCuisine.entities.Projet;

import java.util.*;

public class ProjetView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Projet> projets = new ArrayList<>();
    private static final Map<String,String> data = new HashMap<>();

    public static void creerProjet(Map<Integer, Client> client) {
        System.out.println("--- Création d'un Nouveau Projet ---");
        System.out.print("Entrez le nom du projet : ");
        String nomProjet = scanner.nextLine();
        System.out.print("Entrez la surface de la cuisine (en m²) : ");
        double surface = scanner.nextDouble();

        data.put("nomProjet",nomProjet);
        data.put("surface",String.valueOf(surface));
        ComposantView.ajouterComposants(client,data);
        }

//    public static void afficherProjets() {
//        if (projets.isEmpty()) {
//            System.out.println("Aucun projet n'est enregistré.");
//        } else {
//            for (Projet projet : projets) {
//                System.out.println("Projet : " + projet.getNomProjet() + " - Coût total : " + projet.getCoutTotal());
//            }
//        }
//    }

}

