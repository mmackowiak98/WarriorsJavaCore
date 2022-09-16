import game.Battle;
import characters.Knight;
import characters.Warrior;

public class Main {

    public static void main(String[] args) {
        Warrior war1 = new Warrior();
        Warrior knh1 = new Knight();
        Battle.fight(war1, knh1);


    }
}
