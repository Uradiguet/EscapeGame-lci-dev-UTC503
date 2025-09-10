package cinq.escape.game.entities;

import cinq.escape.game.entities.Enigme;
import cinq.escape.game.entities.Salle;

import java.util.Scanner;

class Prog {
    public static void main(String[] args) throws Exception {
        // Correction de la syntaxe : new Enigme() au lieu de new()
        Enigme e1 = new Enigme("KFC", "Que signifie KFC ?", "Kentucky Fried Chicken");
        Enigme e2 = new Enigme("GPS", "Que signifie GPS ?", "Global Positioning System");
        Enigme e3 = new Enigme("CPU", "Que signifie CPU en informatique ?", "Central Processing Unit");

        Salle s = new Salle("Salle des Acronymes", 30);
        s.ajouterEnigme(e1);
        s.ajouterEnigme(e2);
        s.ajouterEnigme(e3);

        // Correction : getEnigmes() au lieu de getEnigme()
        System.out.println("Nombre d'énigmes dans la salle : " + s.getEnigmes().size());
        System.out.println(s);

        // Test avec un joueur
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez votre pseudo : ");
        String pseudo = scanner.nextLine();

        Joueur joueur = new Joueur(pseudo);
        System.out.println("\n🎮 Bienvenue " + pseudo + " dans l'Escape Game !");

        joueur.jouerDansSalle(s);

        scanner.close();
    }
}

