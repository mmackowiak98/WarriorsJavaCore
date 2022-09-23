package characters;

import game.damage.types.SimpleDamage;

/**
 * Maciej Maćkowiak 19.09.2022
 * <p>
 * Class responsible for implementing object Vampire
 */
public class Vampire extends Warrior {

    private static final int VAMPIRISM = 50;

    public Vampire() {
        super(40, 4);
    }

    /**
     * Overridden method from superclass
     * implemented in a way to work properly for Vampire
     *
     * @param opponent object who's hitting
     */
    @Override
    public void hit(Warrior opponent) {

            final int damageDealt = opponent.receiveDamage(new SimpleDamage(getAttack(),this));
            setHealth(getHealth() + damageDealt * VAMPIRISM / 100);
    }


}
