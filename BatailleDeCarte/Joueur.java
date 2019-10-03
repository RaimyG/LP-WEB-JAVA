import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

/**
 * Joueur
 */
public class Joueur {

    private ArrayList<Carte> cartes;
    private int score;

    public Joueur() {
        this.score = 0;
        this.cartes = new ArrayList<Carte>();
    }

    // Tire la premiere carte du paquet
    public Carte tireUneCarte() {
        // Verif si non vide
        if (cartes.size() == 0) {
            return null;
        } else {
            return cartes.remove(0);
        }
    }

    /* Ajoute une carte au paquet du joueur */
    public void ajouterUneCarte(Carte c) {
        this.cartes.add(c);
    }

    /**
     * @return the score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * @param compteur the compteur to set
     */
    public void incrementeScore() {
        this.score++;
    }

    /* Retourne le nombre de cartes restantes au joeur */
    public int getNbCartes() {
        return this.cartes.size();
    }

}