import java.util.Random;

/**
 * Carte
 */
public class Carte {
    private static String[] couleurs = { "Pique", "Coeur", "Trèfle", "Carreau" };
    private static String[] valeurs = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As" };

    private int couleur;
    private int valeur;

    public Carte(int couleur, int valeur) {

        this.couleur = couleur;
        this.valeur = valeur;

    }

    /* Retourne true si la carte est meilleure */
    public boolean gagne(Carte carte) {
        return this.valeur > carte.getValeur();
    }

    /* Affiche la valeur de la carte (as, roi, ...) */
    public String nomCarte() {
        String nomCarte = valeurs[valeur];
        return nomCarte;
    }

    /**
     * @return the couleur
     */
    public int getCouleur() {
        return couleur;
    }

    /**
     * @return the valeur
     */
    public int getValeur() {
        return valeur;
    }

    /**
     * @param couleur the couleur to set
     */
    public void setCouleur(int couleur) {
        this.couleur = couleur;
    }

    /**
     * @param valeur the valeur to set
     */
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
}