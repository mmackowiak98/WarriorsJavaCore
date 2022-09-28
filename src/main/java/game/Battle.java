package game;


import characters.Army;
import characters.Warrior;

/**
 * Maciej Maćkowiak 14.09.2022
 * Class that implements battle between warriors
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

        var attackingWarrior = attackingArmy.firstAlive();
        var defendingWarrior = defendingArmy.firstAlive();


        while (attackingWarrior.hasNext() && defendingWarrior.hasNext()) {

            fight(attackingWarrior.next(), defendingWarrior.next());

        }
        return attackingWarrior.hasNext();


    }

    public static boolean straightFight(Army attackingArmy, Army defendingArmy){

        while(true) {
            var attackingArmyIterator = attackingArmy.iterator();
            var defendingArmyIterator = defendingArmy.iterator();

            if (!attackingArmyIterator.hasNext()) return false;
            if (!defendingArmyIterator.hasNext()) return true;



            while(attackingArmyIterator.hasNext() && defendingArmyIterator.hasNext()){
                final boolean result = fight(attackingArmyIterator.next(), defendingArmyIterator.next());
                if(result){
                    defendingArmy.removeDeadUnits();
                }else {
                    attackingArmy.removeDeadUnits();
                }

            }



        }


    }


}
