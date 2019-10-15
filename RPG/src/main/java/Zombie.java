public class Zombie extends Monster {


    public Zombie(int hp) {
        super(hp);
    }

    @Override
    public double attack() {
        System.out.println("Aïe ... Vous avez perdu 40 hp.");
        return 40.0;
    }
}
