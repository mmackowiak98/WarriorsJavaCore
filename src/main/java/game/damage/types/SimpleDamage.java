package game.damage.types;

import characters.Warrior;

import java.util.Objects;

public class SimpleDamage implements IDamage {
    private int value;
    Warrior damageDealer;

    public SimpleDamage(int value, Warrior damageDealer) {
        if(value>0) {
            this.value = value;
        }
        this.damageDealer = Objects.requireNonNull(damageDealer);
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
