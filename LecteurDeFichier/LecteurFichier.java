import java.io.File;

/**
 * LecteurFichier
 */
public interface LecteurFichier {

    /* Affiche le nom du fichier */
    void afficheNomFichier();

    boolean existe(File f);

    boolean estUnRepertoire(File f);

    void editerFichier(File f);

    void afficherFichier(File f);

    void creerFichier();
    
}