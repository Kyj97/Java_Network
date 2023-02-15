package day23;

import day23.Diablo.Axe;
import day23.Diablo.Barbarian;
import day23.Diablo.Bow;
import day23.Diablo.Sorceress;

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
        b1.setWeapon(()-> System.out.println("신오브로 아이스볼을 발사"));
        b1.performWeapon();

    }
}
