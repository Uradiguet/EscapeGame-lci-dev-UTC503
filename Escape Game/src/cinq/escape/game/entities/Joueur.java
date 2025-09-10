package cinq.escape.game.entities;

import java.util.InputMismatchException;
import java.util.Scanner;

class Joueur {
    private String pseudo;
    private int score;
    private Scanner scanner;

    public Joueur(String pseudo) {
        this.pseudo = pseudo;
        this.score = 0;
        this.scanner = new Scanner(System.in);
    }

    public void jouerDansSalle(Salle salle) {
        System.out.println("\n🚪 Bienvenue dans la salle : " + salle.getNom());
        System.out.println("⏰ Temps limite : " + salle.getTempsLimite() + " minutes");

        while (!salle.estTerminee()) {
            salle.afficherToutesEnigmes();

            System.out.println("\n💭 Actions disponibles :");
            System.out.println("1-" + salle.getEnigmes().size() + ": Sélectionner une énigme");
            System.out.println("0: Quitter");
            System.out.print("Votre choix : ");

            try {
                int choix = scanner.nextInt();
                scanner.nextLine(); // Consommer la ligne

                if (choix == 0) {
                    System.out.println("👋 Au revoir !");
                    return;
                }

                if (choix >= 1 && choix <= salle.getEnigmes().size()) {
                    System.out.print("Votre réponse : ");
                    String reponse = scanner.nextLine();

                    try {
                        boolean resultat = salle.resoudreEnigme(choix - 1, reponse);
                        if (resultat) {
                            System.out.println("🔓 Bravo ! Énigme résolue !");
                            score += 10;
                            System.out.println("📊 Score actuel : " + score);
                        } else {
                            System.out.println("❌ Mauvaise réponse, essayez encore !");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("❌ " + e.getMessage());
                    }
                } else {
                    System.out.println("❌ Choix invalide !");
                }
            } catch (InputMismatchException e) {
                System.out.println("❌ Veuillez entrer un nombre valide !");
                scanner.nextLine(); // Nettoyer l'input
            }
        }

        if (salle.estTerminee()) {
            System.out.println("\n🎉 Félicitations ! Vous avez terminé la salle !");
            System.out.println("🏆 Score final : " + score);
        }
    }

    public String getPseudo() { return pseudo; }
    public int getScore() { return score; }
}

