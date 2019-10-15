public class Player {
    private double hp;
    private int coins;
    private Weapon weapon;

    public Player() {
        this.hp = 200.0;
        this.coins = 500;
        this.weapon = new Axe();
    }

    public void attack(Monster monster) {
        Double damage = weapon.getDamage();
        monster.loseHp(damage);
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
