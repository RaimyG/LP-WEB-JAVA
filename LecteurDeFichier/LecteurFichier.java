import java.io.File;

/**
 * LecteurFichier
 */
public interface LecteurFichier {

    // Affiche le contenu du fichier
    void lisFichier(File file);

    // Liste les fichiers 
    void listeFichiers(File f);
    
    // Supprime le fichier
    // boolean supprimerFichier(File f);
}