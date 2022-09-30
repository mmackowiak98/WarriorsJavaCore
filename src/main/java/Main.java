

import characters.Army;
import characters.Dragon;
import characters.Warrior;
import characters.weapons.Weapon;

import java.util.Iterator;

import static characters.weapons.Weapon.*;
import static characters.weapons.Weapons.newSword;


public class Main {

    public static void main(String[] args) {

        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Dragon::new,1);
        army2.addUnits(Warrior::new,3);



        army2.equipWarriorAtPosition(4,newSword());
        //just to check if working properly
        Iterator<Warrior> iterator = army2.iterator();
        while(iterator.hasNext()){
            Warrior next = iterator.next();
            System.out.println(next.getAttack());
            System.out.println(next.getHealth());

        }
    }
}
