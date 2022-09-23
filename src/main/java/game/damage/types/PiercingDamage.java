package game.damage.types;

import characters.Warrior;

public class PiercingDamage implements IDamage{

    private int value;
    private Warrior damageDealer;

    public PiercingDamage(int value, Warrior damageDealer) {
        this.value = value;
        this.damageDealer = damageDealer;
    }

    @Override
    public Warrior getDamageDealer() {
        return damageDealer;
    }

    @Override
    public int getValue() {
        return value;
    }
}
