package characters;


import characters.characteristics.CanReceiveDamage;
import characters.characteristics.IDamageDone;

public class Lancer extends Warrior implements IDamageDone {


    public Lancer() {
        super(50, 6);
    }


    @Override
    public void hit(CanReceiveDamage opponent) {


        int finalDamage = damageDealt(opponent);

        if (opponent instanceof ArmyWarrior armyUnit) {

            final Warrior warriorBehind = armyUnit.getWarriorBehind();

            if (warriorBehind != null) {

                int reducedDamage = finalDamage / 2;
                warriorBehind.receiveDamage(() -> reducedDamage);

            }
        }


    }
}
