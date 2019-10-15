public abstract class Weapon {

    private double damage;
    private String name;
    private int price;


    public Weapon(String name, double damage, int price) {
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    public double getDamage() {
        return damage;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
