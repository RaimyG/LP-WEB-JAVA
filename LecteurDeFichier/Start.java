import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Start
 */
public class Start {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File dossierCourant = new File("./");

        Fichiertxt file = new Fichiertxt();

        System.out.println("Les commandes disponibles sont : ls; cat <fichier>; reverse <fichier>; diff <fichier1> <fichier2>; exit");

        while (true) {
            String user = sc.nextLine();
            String[] cmd = user.split(" ");

            switch (cmd[0]) {

            case "ls": // Liste les fichiers
                file.listeFichiers(dossierCourant);
                break;

            case "reverse":
                if (cmd.length == 2) {
                    File f = new File(cmd[1]);
                    file.lisFichierEnvers(f);
                } else {
                    System.out.println("Usage: reverse <fichier>");
                }
                break;

            case "cat": // Affiche le contenu du fichier
                if (cmd.length == 2) {
                    File f2 = new File(cmd[1]);
                    file.lisFichier(f2);
                } else {
                    System.out.println("Usage: cat <fichier>");
                }
                break;

            case "diff": // Affiche le contenu du fichier
                if (cmd.length == 3) {
                    File f3 = new File(cmd[1]);
                    File f4 = new File(cmd[2]);
                    file.diff(f3,f4);
                } else {
                    System.out.println("Usage: diff <fichier1> <fichier2>");
                }
                break;

            case "exit":
                System.exit(0);
                break;

            default:
                break;
            }
        }

    }
}