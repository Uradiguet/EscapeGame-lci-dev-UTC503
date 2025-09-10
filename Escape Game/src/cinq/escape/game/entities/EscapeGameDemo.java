package cinq.escape.game.entities;

import java.util.Scanner;

class EscapeGameDemo {
    public static void main(String[] args) {
        // Création de plusieurs salles thématiques
        Salle salleInformatique = new Salle("Laboratoire Informatique", 20);
        salleInformatique.ajouterEnigme(new Enigme("HTML", "Langage de balisage pour le web", "HyperText Markup Language"));
        salleInformatique.ajouterEnigme(new Enigme("RAM", "Mémoire vive de l'ordinateur", "Random Access Memory"));

        Salle salleHistoire = new Salle("Bibliothèque Historique", 25);
        salleHistoire.ajouterEnigme(new Enigme("1969", "Année du premier pas sur la Lune", "1969"));
        salleHistoire.ajouterEnigme(new Enigme("Napoléon", "Empereur français défait à Waterloo", "Bonaparte"));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez votre pseudo : ");
        String pseudo = scanner.nextLine();

        Joueur joueur = new Joueur(pseudo);

        System.out.println("\n🎮 Escape Game Multi-Salles !");
        System.out.println("Choisissez votre salle :");
        System.out.println("1. " + salleInformatique.getNom());
        System.out.println("2. " + salleHistoire.getNom());

        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1:
                joueur.jouerDansSalle(salleInformatique);
                break;
            case 2:
                joueur.jouerDansSalle(salleHistoire);
                break;
            default:
                System.out.println("Choix invalide, lancement de la salle par défaut...");
                joueur.jouerDansSalle(salleInformatique);
        }

        scanner.close();
    }
}