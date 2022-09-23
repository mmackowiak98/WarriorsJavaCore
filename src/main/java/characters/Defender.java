package characters;


import game.damage.types.IDamage;
import game.damage.types.SimpleDamage;

/**
 * Maciej Maćkowiak 19.09.2022
 *
 * Class responsible for implementing object Defender
 */
public class Defender extends Warrior {

    private static final int DEFENSE = 2;

    public Defender() {
        super(60, 3);
    }

    protected int getDefense(){
        return DEFENSE;
    }

    /**
     * Overridden method from superclass
     * implemented in a way to work properly for Defender
     *
     * @param damage amount of health to take away
     * @return actual damage that opponent received
     */
    @Override
    int receiveDamage(IDamage damage) {
        int finalDamage = damage.getValue() - getDefense();

        if (damage.getValue() < getDefense()) {
            super.receiveDamage(new SimpleDamage(0,this));
        } else {
            super.receiveDamage(new SimpleDamage(finalDamage,this));
        }
        return finalDamage;
    }
}
