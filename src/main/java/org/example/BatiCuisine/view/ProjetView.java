package org.example.BatiCuisine.view;

import org.example.BatiCuisine.entities.Client;
import org.example.BatiCuisine.entities.MainDoeuvre;
import org.example.BatiCuisine.entities.Materiel;
import org.example.BatiCuisine.entities.Projet;

import java.util.*;

import static org.example.BatiCuisine.view.ResultatView.result;

public class ProjetView {
    private static final Scanner scanner = new Scanner(System.in);


    public static void creerProjet(Projet projet) {
        System.out.println("--- Création d'un Nouveau Projet ---");
        System.out.print("Entrez le nom du projet : ");
        String nomProjet = scanner.nextLine();
        System.out.print("Entrez la surface de la cuisine (en m²) : ");
        double surface = scanner.nextDouble();

        projet.setNomProjet(nomProjet);
        projet.setSurface(surface);


        List<Materiel> materiels =  ComposantView.ajouterComposants(projet);
        List<MainDoeuvre> mainDoeuvres = ComposantView.ajouterMainDoeuvre(projet);

            System.out.println("--- Calcul du coût total ---\n");

            System.out.print("Souhaitez-vous appliquer une TVA au projet ? (y/n) : ");
            String reponseTVA = scanner.nextLine().trim().toLowerCase();

            if (reponseTVA.equals("y")) {
                System.out.print("Entrez le pourcentage de TVA (%) : ");
                try {
                    double tva = scanner.nextDouble();
                    projet.setTva(tva);

                } catch (Exception e) {
                    System.out.println("Pourcentage de TVA invalide. La TVA sera considérée comme 0.");
                }
                scanner.nextLine();

                System.out.print("Souhaitez-vous appliquer une marge bénéficiaire au projet ? (y/n): ");
                String reponseMarge = scanner.nextLine().trim().toLowerCase();

                if (reponseMarge.equals("y")) {
                    System.out.print("Entrez le pourcentage de marge bénéficiaire (%) : ");
                    try {
                        double marge = scanner.nextDouble();
                        projet.setMargeBeneficiaire(marge);

                    } catch (Exception e) {
                        System.out.println("Pourcentage de marge bénéficiaire invalide. La marge bénéficiaire sera considérée comme 0.");
                    }
                }
            } else if (reponseTVA.equals("n")) {
                System.out.print("Souhaitez-vous appliquer une marge bénéficiaire au projet ? (y/n): ");
                String reponseMarge = scanner.nextLine().trim().toLowerCase();

                if (reponseMarge.equals("y")) {
                    System.out.print("Entrez le pourcentage de marge bénéficiaire (%) : ");
                    try {
                        double marge = scanner.nextDouble();
                        projet.setMargeBeneficiaire(marge);
                    } catch (Exception e) {
                        System.out.println("Pourcentage de marge bénéficiaire invalide. La marge bénéficiaire sera considérée comme 0.");
                    }
                }
            } else {
                System.out.println("Réponse invalide. La TVA et la marge bénéficiaire seront considérées comme 0.");
            }


            System.out.println("Calcul du coût en cours ...");
            result(projet,materiels,mainDoeuvres);
        }

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



