import java.util.Random;

public abstract class Monster {

    private double hp;

    public Monster (double hp) {
        this.hp = hp;
    }

    public abstract double attack();

    public void loseHp(Double damage) {
        hp = hp - damage;
        if (isDead()) {
            System.out.println("Le monstre est mort.");
        } else {
            System.out.println("Il reste " + hp + " hp au monstre.");
        }
    }

    private boolean isDead() {
        return hp <= 0;
    }


}
