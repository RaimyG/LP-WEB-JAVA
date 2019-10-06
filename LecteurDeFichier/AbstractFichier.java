import java.io.File;
import java.io.FileInputStream;

/**
 * AbstractFichier
 */
public abstract class AbstractFichier implements LecteurFichier {

    public AbstractFichier() {
    }

    public abstract void lisFichier(File f);

    @Override
    public void listeFichiers(File f) {
        String[] liste;

        liste = f.list();
        for (String fichier : liste) {
            System.out.println(fichier);
        }
    }
}