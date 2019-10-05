import java.io.File;
import java.io.FileInputStream;

/**
 * AbstractFichier
 */
public abstract class AbstractFichier implements LecteurFichier {

    public AbstractFichier() {
    }

    @Override
    public void creerFichier() {
        FileInputStream in = null;
        File f = new File("xanadu.txt");
        try {
            in = new FileInputStream(f); // ouverture du fichier // Throws: FileNotFoundException : => try/catch
            // OPERATIONS DE LECTURE
        } finally {
            if (in != null) {
            }
        }
    }

    public abstract void test();

}