package game;

import characters.Warrior;

/**
 * Maciej Maćkowiak 14.09.2022
 * Class that implements battle between 2 warriors
 */
public class Battle {

    /**
     * @param warrior1 first warrior
     * @param warrior2 second warrior
     * @return returns true if warrior1 wins and false if warrior2 wins
     */
    public static boolean fight(Warrior warrior1, Warrior warrior2) {

        //looping through till one of warrior is dead
        while (warrior1.isAlive() || warrior2.isAlive()) {

            //First warrior attacks second warrior
            warrior2.setHealth(warrior2.getHealth() - warrior1.getAttack());

            //Checks if second warrior is still alive after attack, breaking loop if not alive
            if (!warrior2.isAlive()) {
                break;
            }

            warrior1.setHealth(warrior1.getHealth() - warrior2.getAttack());

            if (!warrior1.isAlive()) {
                break;
            }

        }

        //Checking only warrior1 because if he's dead then warrior2 wins and function return false
        return warrior1.isAlive();
    }


}
