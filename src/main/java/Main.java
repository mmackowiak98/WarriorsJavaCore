

import characters.*;
import game.Battle;

import java.util.Iterator;
import static characters.weapons.Weapons.*;


public class Main {

    public static void main(String[] args) {

        Army army1 = new Army();
        Army army2 = new Army();



        army1.addUnits(Dragon::new,1);
        army2.addUnits(Warrior::new,3);
        Warrior defender = new Defender();
        Warrior lancer = new Lancer();
        lancer.equipWeapon(newKatana());
        defender.equipWeapon(newShield());
        System.out.println(defender.getHealth());



        army2.equipWarriorAtPosition(2,newSword());
        Battle.armyFight(army1,army2);
        //just to check if working properly
        Iterator<Warrior> iterator = army2.iterator();
        while(iterator.hasNext()){
            Warrior next = iterator.next();
            System.out.println(next.getAttack());
            System.out.println(next.getHealth());

        }
    }
}



