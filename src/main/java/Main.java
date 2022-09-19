import characters.*;
import game.Battle;

public class Main {

    public static void main(String[] args) {

        Army army1 = new Army();
        Army army2 = new Army();


        army1.addUnits(Warrior::new, 20);
        army1.addUnits(Knight::new,10);

        army2.addUnits(Warrior::new, 21);
        army2.addUnits(Knight::new,3);

        Warrior defender = new Defender();
        Warrior vampire = new Vampire();


        Battle.fight(defender,vampire);


    }
}
