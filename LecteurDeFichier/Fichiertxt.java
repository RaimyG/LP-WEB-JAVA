import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Fichiertxt
 */
public class Fichiertxt extends AbstractFichier {

    public Fichiertxt() {
        super();
    }

    @Override
    public void lisFichier(File file) {
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);

            int content;
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
            System.out.println();

        } catch (IOException e) {
            System.out.println("Ce fichier n'existe pas");
            // e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void lisFichierEnvers(File file) {
        FileInputStream fis = null;
        BufferedReader reader = null;

        try {
            fis = new FileInputStream(file);
            reader = new BufferedReader(new InputStreamReader(fis));

            String line = reader.readLine();
            String[] lines = new String[10];

            // Stock les lignes dans un taleau de string
            for (int i = 0; line != null; i++) {
                line = reader.readLine();
                lines[i] = line;
            }

            // Lis le tableau en commencant de la fin
            for (int i = lines.length-1; i >= 0; i++) {
                System.out.println(lines[i]);
            }

        } catch (IOException e) {
            System.out.println("Ce fichier n'existe pas");
            // e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}