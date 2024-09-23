package org.example.BatiCuisine.utils;

import java.util.regex.Pattern;

public class ValidationUtil {

    public static boolean estNomValide(String nom) {
        return nom != null && !nom.trim().isEmpty();
    }

    public static boolean estAdresseValide(String adresse) {
        return adresse != null && !adresse.trim().isEmpty();
    }

    public static boolean estTelephoneValide(String telephone) {
        String regex = "\\d{10}"; // Exemple pour un numéro de 10 chiffres
        return telephone != null && Pattern.matches(regex, telephone);
    }

    public static boolean estSurfaceValide(double surface) {
        return surface > 0;
    }

    public static boolean estTauxHoraireValide(double tauxHoraire) {
        return tauxHoraire >= 0;
    }

    public static boolean estQuantiteValide(double quantite) {
        return quantite > 0;
    }
}
