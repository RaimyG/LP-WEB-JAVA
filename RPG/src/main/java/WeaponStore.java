import java.util.ArrayList;

public class WeaponStore {

    private ArrayList store;

    public WeaponStore() {
        store = new ArrayList<Weapon>();
        store.add(new Axe());
        store.add(new MegaSword());
    }

    public ArrayList getStore() {
        return store;
    }

    public Weapon sell(int weapon) {
        return (Weapon) store.remove(weapon);
    }
}
