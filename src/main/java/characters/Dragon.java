package characters;

import characters.characteristics.CanReceiveDamage;

public class Dragon extends Warrior {
    private static final int FIRE_BREATH_MASS_DAMAGE = 10;
    private int rounds = 0;

    public Dragon() {
        super(50, 0);
    }

    @Override
    public void hit(CanReceiveDamage opponent) {
        rounds++;
        if(rounds==3) {
            if (opponent instanceof ArmyWarrior armyUnit) {
                while (armyUnit.hasNext()) {
                    setOnFire(armyUnit.next());
                }
            }
            rounds=0;
        }
    }
    private void setOnFire(CanReceiveDamage opponent) {
        opponent.receiveDamage(() -> FIRE_BREATH_MASS_DAMAGE);
    }
}
