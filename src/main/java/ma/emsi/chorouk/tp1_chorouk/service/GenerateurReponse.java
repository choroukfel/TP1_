
package ma.emsi.chorouk.tp1_chorouk.service;

import jakarta.enterprise.context.Dependent;
import java.io.Serializable;
import java.util.Locale;

@Dependent
public class GenerateurReponse implements Serializable {

    public String genererReponse(String question, String roleSysteme) {

        StringBuilder resultat = new StringBuilder("||");

        // Conserver le rôle système du TP0
        if (roleSysteme != null) {
            resultat.append(roleSysteme.toUpperCase(Locale.FRENCH))
                    .append("\n");
        }

        if (question == null || question.trim().isEmpty()) {
            resultat.append("Aucun texte à analyser.");
            resultat.append("||");
            return resultat.toString();
        }

        // PARTIE 1 : ANALYSE DU TEXTE
        String texte = question.trim();
        String[] mots = texte.split("\\s+");

        int nombreMots = mots.length;
        int nombreCaracteres = texte.length();
        int nombreVoyelles = 0;

        String voyelles = "aeiouyàâäéèêëîïôöùûüÿ";

        for (char lettre : texte.toLowerCase(Locale.FRENCH).toCharArray()) {
            if (voyelles.indexOf(lettre) >= 0) {
                nombreVoyelles++;
            }
        }

        String motPlusLong = "";

        for (String mot : mots) {
            if (mot.length() > motPlusLong.length()) {
                motPlusLong = mot;
            }
        }

        resultat.append("=== ANALYSE DU TEXTE ===\n");
        resultat.append("Nombre de mots : ").append(nombreMots).append("\n");
        resultat.append("Nombre de caractères : ").append(nombreCaracteres).append("\n");
        resultat.append("Nombre de voyelles : ").append(nombreVoyelles).append("\n");
        resultat.append("Mot le plus long : ").append(motPlusLong).append("\n\n");

        // PARTIE 2 : TRANSFORMATION CREATIVE
        String majuscules = texte.toUpperCase(Locale.FRENCH);
        String inverse = new StringBuilder(texte).reverse().toString();

        StringBuilder alternance = new StringBuilder();
        boolean mettreMajuscule = true;

        for (char lettre : texte.toCharArray()) {
            if (Character.isLetter(lettre)) {
                if (mettreMajuscule) {
                    alternance.append(Character.toUpperCase(lettre));
                } else {
                    alternance.append(Character.toLowerCase(lettre));
                }
                mettreMajuscule = !mettreMajuscule;
            } else {
                alternance.append(lettre);
            }
        }

        resultat.append("=== TRANSFORMATION CREATIVE ===\n");
        resultat.append("Majuscules : ").append(majuscules).append("\n");
        resultat.append("Texte inversé : ").append(inverse).append("\n");
        resultat.append("Alternance : ").append(alternance).append("\n");

        resultat.append("||");

        return resultat.toString();
    }
}
