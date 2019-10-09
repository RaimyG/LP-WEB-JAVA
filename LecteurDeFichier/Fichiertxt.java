import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
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

    // Affiche le contenu d'un fichier
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

    // Lis un fichier et l'affiche à l'envers (en terme de ligne)
    public void lisFichierEnvers(File file) {
        FileInputStream fis = null;
        BufferedReader reader = null;

        try {
            fis = new FileInputStream(file);
            reader = new BufferedReader(new InputStreamReader(fis));

            int nbLine = (int) getLineCount(file);

            String[] lines = new String[nbLine];
            String line = "";

            // Stock les lignes dans un tableau de string
            for (int i = 0; i < nbLine; i++) {
                line = reader.readLine();
                lines[i] = line;
            }

            // Lis le tableau en commencant de la fin
            for (int i = nbLine - 1; i >= 0; i--) {
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

    // Affiche les lignes que les 2 fichiers ont en commun
    public void diff(File file1, File file2) {
        FileInputStream fis1 = null;
        BufferedReader reader1 = null;
        FileInputStream fis2 = null;
        BufferedReader reader2 = null;

        try {
            fis1 = new FileInputStream(file1);
            reader1 = new BufferedReader(new InputStreamReader(fis1));

            fis2 = new FileInputStream(file2);
            reader2 = new BufferedReader(new InputStreamReader(fis2));

            int nbLine1 = (int) getLineCount(file1);
            int nbLine2 = (int) getLineCount(file2);
            int nbMaxLine = (nbLine1 < nbLine2) ? nbLine1 : nbLine2;

            String[] lines = new String[nbMaxLine];
            String line1 = "";
            String line2 = "";

            // Stock les lignes dans un tableau de string
            for (int i = 0; i < nbMaxLine; i++) {
                line1 = reader1.readLine();
                line2 = reader2.readLine();
                if (line1.equals(line2)) {
                    lines[i] = line1;
                }
            }

            System.out.println(lines);
            // Lis le tableau
            System.out.println("Les lignes en communes :");
            for (int i = 0; i < lines.length; i++) {
                System.out.println(lines[i]);
            }

        } catch (IOException e) {
            System.out.println("Ce fichier n'existe pas");
            // e.printStackTrace();
        } finally {
            try {
                if (fis1 != null)
                    fis1.close();
                if (fis2 != null)
                    fis2.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Count file rows.
     *
     * @param file file
     * @return file row count
     * @throws IOException
     */
    private static long getLineCount(File file) throws IOException {

        try (BufferedInputStream is = new BufferedInputStream(new FileInputStream(file), 1024)) {

            byte[] c = new byte[1024];
            boolean empty = true, lastEmpty = false;
            long count = 0;
            int read;
            while ((read = is.read(c)) != -1) {
                for (int i = 0; i < read; i++) {
                    if (c[i] == '\n') {
                        count++;
                        lastEmpty = true;
                    } else if (lastEmpty) {
                        lastEmpty = false;
                    }
                }
                empty = false;
            }

            if (!empty) {
                if (count == 0) {
                    count = 1;
                } else if (!lastEmpty) {
                    count++;
                }
            }

            return count;
        }
    }

}