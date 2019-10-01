import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Bataille
 */
public class Bataille {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Boolean partieEnCours = true;

        ArrayList<Carte> paquet = new ArrayList<Carte>();

        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();

        /* Generation du paquet */
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                paquet.add(new Carte(i, j));
            }
        }

        /* Melange et distribution des cartes */
        Collections.shuffle(paquet);
        for (int index = 0; index < paquet.size(); index++) {
            if (index < 26) {
                j1.ajouterUneCarte(paquet.get(index));
            } else {
                j2.ajouterUneCarte(paquet.get(index));
            }
        }

        /* Boucle de jeu */
        System.out.println("Appuyez sur entrer pour faire jouer les 2 joueurs ...");

        while (partieEnCours) {

            // A mettre en commentaire pour laisser la partie se jouer toute seule
            // scan.nextLine();

            Carte c1 = j1.tireUneCarte();
            Carte c2 = j2.tireUneCarte();

            System.out.println("J1 joue " + c1.nomCarte() + " | " + "J2 joue " + c2.nomCarte());

            if (c1.getValeur() == c2.getValeur()) {

                System.out.println("Egalité");

                // Chacun recupere sa carte
                j1.ajouterUneCarte(c1);
                j2.ajouterUneCarte(c2);

            } else {
                
                if (c1.gagne(c2)) {

                    System.out.println("J1 gagne la manche");

                    j1.ajouterUneCarte(c1); // Recupere sa carte et celle de son adversaire
                    j1.ajouterUneCarte(c2);
                    j1.incrementeScore();

                } else {

                    System.out.println("J2 gagne la manche");

                    j2.ajouterUneCarte(c1); // Recupere sa carte et celle de son adversaire
                    j2.ajouterUneCarte(c2);
                    j2.incrementeScore();

                }

                // Affiche les scores
                System.out.println("Score : ");
                System.out.println("J1 " + j1.getScore() + " --- " + j2.getScore() + " J2");

                System.out.println("\n...\n");

                // Si l'un des joueurs n'a plus de carte on arrete la partie
                if (j1.getNbCartes() == 0 || j2.getNbCartes() == 0) {
                    partieEnCours = false;
                }
            }

        }

        // Affiche score final et gagnant
        System.out.println("Partie terminée - Score final :");
        System.out.println(j1.getScore() + " points VS " + j2.getScore() + " points");

        if (j1.getScore() > j2.getScore()) {
            System.out.println("Le joueur 1 gagne");
        } else {
            System.out.println("Le joueur 2 gagne");
        }

        System.out.println("C'était vraiment pas ouf ce jeu");
    }
}
