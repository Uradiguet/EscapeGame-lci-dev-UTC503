package cinq.escape.game;

import cinq.escape.game.entities.Enigme;
import cinq.escape.game.entities.Salle;

public class Prog {
    public static void main(String[]args){
        Enigme e1 = new("KFC", "Que signifie KFC ?", "Kentucky Fried Chicken");
        Enigme e2 = e1;
        Salle s = new Salle("C11", 30);
        s.ajouterEnigme(e1);
        s.ajouterEnigme(e2);
        System.out.println(s.getEnigme().size());
}
