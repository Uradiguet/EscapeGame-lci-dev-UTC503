package cinq.escape.game.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Salle {
   private String nom;
   private Set<Enigme> enigme;
   private int tempsLimite;
   private boolean estTerminee;

    public Salle(String nom, int tempsLimite) {
         this.nom = nom;
         this.enigme = new HashSet<>(enigme);
         this.tempsLimite = tempsLimite;
         this.estTerminee = false;
    }

    public void ajouterEnigme(Enigme e){
        if(!enigme.contains(e)){
            this.enigme.add(e);
        }

    }




    public resoudreEnigme(int index, String tentative){
        if(index < 0 || index >= enigme.size()){
            throw new IndexOutOfBoundsException("Index d'énigme invalide");
        }
        Enigme e = (Enigme) enigme.get(index);
        return e.resoudre(tentative);
    }

    public estTerminee(){
        for(Object obj : enigme){
            Enigme e = (Enigme) obj;
            if(!e.estResolue()){
                return false;
            }
        }
        this.estTerminee = true;
        return true;
    }

    public afficherEnigmeNonResolue(){
        for(Object obj : enigme){
            Enigme e = (Enigme) obj;
            if(!e.estResolue()){
                System.out.println(e);
                return;
            }
        }
        System.out.println("Toutes les énigmes sont résolues !");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
