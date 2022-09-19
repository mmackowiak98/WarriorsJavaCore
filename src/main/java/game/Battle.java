package game;

import characters.Army;
import characters.Warrior;

/**
 * Maciej Maćkowiak 14.09.2022
 * Class that implements battle between 2 warriors
 */
public class Battle {
    private Battle() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Method implementing fight between 2 warriors
     *
     * @param warrior1 first warrior
     * @param warrior2 second warrior
     * @return returns true if warrior1 wins and false if warrior2 wins
     */
    public static boolean fight(Warrior warrior1, Warrior warrior2) {

        //looping through till one of warrior is dead
        while (warrior1.isAlive() && warrior2.isAlive()) {

            //First warrior attacks second warrior
            warrior1.hit(warrior2);

            //Checks if second warrior is still alive after attack
            if (warrior2.isAlive()) {

                //Second warrior attacks second warrior
                warrior2.hit(warrior1);

            }

        }

        //Checking only warrior1 because if he's dead then warrior2 wins and function return false
        return warrior1.isAlive();
    }

    /**
     * Method implementing fight between two armies
     * each warrior fight one by one till someone is dead
     *
     * @param attackingArmy - attacking army
     * @param defendingArmy - defending army
     * @return - returns true if attacking army wins, otherwise false
     */
    public static boolean armyFight(Army attackingArmy, Army defendingArmy) {

        while (attackingArmy.isNotEmpty() && defendingArmy.isNotEmpty()) {

            final Warrior attackingArmySingleUnit = attackingArmy.getSingleUnit();
            final Warrior defendingArmySingleUnit = defendingArmy.getSingleUnit();


            final boolean fightResult = Battle.fight(attackingArmySingleUnit, defendingArmySingleUnit);

            //True - attackingArmy warrior wins, so we're deleting unit from defending army
            if (fightResult) {

                defendingArmy.removeUnit(defendingArmySingleUnit);

            }
            //False - attackingArmy warrior lost, so we're deleting unit from it
            else {

                attackingArmy.removeUnit(attackingArmySingleUnit);

            }

        }
        return attackingArmy.size() > 0;
    }


}
