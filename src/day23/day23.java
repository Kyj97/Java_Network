package day23;

public class day23 {
    public static void main(String[] args) {
        Sorceress s1 = new Sorceress();
        Barbarian b1 = new Barbarian();
        Axe berserkerAxe = new Axe();
        Bow windForce = new Bow();
        b1.setWeapon(berserkerAxe);
        s1.setWeapon(windForce);
        s1.performWeapon();
        b1.performWeapon();
        s1.setWeapon(new Axe()); //익명도끼를 집었다는뜻, 무기교체
        s1.performWeapon();
        s1.info();

    }
}
