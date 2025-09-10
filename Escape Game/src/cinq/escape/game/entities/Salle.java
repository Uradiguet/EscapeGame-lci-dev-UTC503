package cinq.escape.game.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Salle {
    private String nom;
    private Set<Enigme> enigmes;
    private int tempsLimite;
    private boolean estTerminee;

    public Salle(String nom, int tempsLimite) {
        this.nom = nom;
        this.enigmes = new HashSet<>();
        this.tempsLimite = tempsLimite;
        this.estTerminee = false;
    }

    public void ajouterEnigme(Enigme e) {
        //exception si e est null ou déjà dans la liste
        if(e == null) {
            throw new IllegalArgumentException("La liste des énigmes n'a pas été initialisée.");
        }
        if(enigmes.contains(e)){
            throw new IllegalArgumentException("L'énigme est déjà dans la liste.");
        }
        this.enigmes.add(e);
    }

    public boolean resoudreEnigme(int index, String tentative) {
        if (index < 0 || index >= enigmes.size()) {
            throw new IndexOutOfBoundsException("Index d'énigme invalide");
        }

        List<Enigme> listeEnigmes = new ArrayList<>(enigmes);
        Enigme e = listeEnigmes.get(index);
        return e.resoudre(tentative);
    }


    public boolean estTerminee() {
        for (Enigme e : enigmes) {
            if (!e.estResolue()) {
                return false;
            }
        }
        this.estTerminee = true;
        return true;
    }

    public void afficherEnigmeNonResolue() {
        boolean aucuneNonResolue = true;
        for (Enigme e : enigmes) {
            if (!e.estResolue()) {
                System.out.println(e);
                aucuneNonResolue = false;
            }
        }
        if (aucuneNonResolue) {
            System.out.println("Toutes les énigmes sont résolues !");
        }
    }

    public void afficherToutesEnigmes() {
        System.out.println("\n🧩 Énigmes dans " + nom + " :");
        List<Enigme> listeEnigmes = new ArrayList<>(enigmes);
        for (int i = 0; i < listeEnigmes.size(); i++) {
            System.out.println((i + 1) + ". " + listeEnigmes.get(i));
        }
    }


    public Set<Enigme> getEnigmes() {
        return enigmes;
    }

    public String getNom() {
        return nom;
    }

    public int getTempsLimite() {
        return tempsLimite;
    }

    @Override
    public String toString() {
        return "Salle: " + nom + " (Temps limite: " + tempsLimite + " min, " +
                enigmes.size() + " énigmes)";
    }
}

