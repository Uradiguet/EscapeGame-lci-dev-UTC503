package cinq.escape.game.entities;

import java.util.*;

// Classe Enigme corrigée et améliorée
public class Enigme {
    private String titre;
    private String description;
    private String codeSolution;
    private boolean resolue;

    public Enigme() {
        this("", "", "");
    }

    public Enigme(String titre, String description, String codeSolution) {
        this.titre = titre;
        this.description = description;
        this.codeSolution = codeSolution;
        this.resolue = false;
    }

    public boolean resoudre(String tentative) {
        if (tentative != null) {
            this.resolue = tentative.trim().equalsIgnoreCase(codeSolution);
        }
        return this.resolue;
    }

    // Getter pour estResolue (manquait dans votre code)
    public boolean estResolue() {
        return this.resolue;
    }

    @Override
    public String toString() {
        String statut = resolue ? "[✅ RÉSOLUE]" : "[❓ À RÉSOUDRE]";
        return statut + " " + titre + "\n   " + description;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Enigme)) {
            return false;
        }
        Enigme autreEnigme = (Enigme) obj;
        // Correction : utilisation de .equals() au lieu de ==
        return Objects.equals(this.titre, autreEnigme.titre) &&
                Objects.equals(this.description, autreEnigme.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titre, description);
    }

    // Getters
    public String getTitre() { return titre; }
    public String getDescription() { return description; }
}