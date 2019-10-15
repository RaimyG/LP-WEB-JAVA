import java.util.ArrayList;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) {
        //Declaration des variables utiles
        Scanner scanner = new Scanner(System.in);
        int action;

        // Declaration des variables du jeu
        Player player = new Player();
        WeaponStore store = new WeaponStore();
        Monster zombie = new Zombie(150);

        System.out.println("Bienvenue dans ce mini RPG vraiment pas ouf.");
        System.out.println("Vous avez avec vous 0 pièce d'or, une hache et 200 points de vie.");
        System.out.println("Zééé partiii !");
        System.out.println("- - - - - - -- -- - - - - - - - - - - - -- - - - - -- - - - -- - -- - ");

        while (true) {
            choices();

            action = scanner.nextInt();

            switch (action) {
                case 1 : // Attack monster
                    player.attack(zombie);
                    // System.out.println("Le monstre est mort, vous gagnez 50 pièces d'or.");
                    break;
                case 2 : // Escape
                    System.out.println("Vous prenez la fuite, faible que vous êtes ...");
                    break;
                case 3 : // Buy new weapon
                    weaponStore(store, player);
                    System.out.println("Vous achetez une nouvelle arme..");
                    break;
                case 4 : // Exit
                    System.out.println("A bientôt camarade !");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Arf ... Je ne connais pas cette action.");
                    break;
            }
        }
    }

    private static void choices() {
        System.out.println("Que faire ?");
        System.out.println("1 - Taper le monstre | 2 - Fuire | 3 - Acheter une nouvelle arme (Vous perdrez de la vie) | 4 - Quitter le jeu");
    }

    private static void weaponStore(WeaponStore store, Player player) {
        ArrayList<Weapon> armes = store.getStore();
        for ( Weapon arme: armes ) {
            System.out.println(arme.getName() + " - " + arme.getPrice() + " pièces d'or");
        }
        System.out.println("Quelle arme souhaites-vous ? (1, 2, ...)");
        Scanner scanner = new Scanner(System.in);
        int ans = scanner.nextInt();
        Weapon newWeapon = store.sell(ans-1);
        player.setWeapon(newWeapon);
    }
}
