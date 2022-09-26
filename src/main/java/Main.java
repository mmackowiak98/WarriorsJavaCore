

import characters.Army;
import characters.Dragon;
import characters.Vampire;
import characters.Warrior;
import game.Battle;



public class Main {

    public static void main(String[] args) {

        Army army1 = new Army();
        Army army2 = new Army();

        army1.addUnits(Dragon::new,1);
        army2.addUnits(Warrior::new,3);


        Battle.armyFight(army1,army2);


    }
}
