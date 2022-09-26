package characters;

/**
 * Maciej Maćkowiak 19.09.2022
 * <p>
 * Class responsible for implementing object Vampire
 */
public class Vampire extends Warrior implements IDamageDone {

    private static final int VAMPIRISM = 50;

    public Vampire() {
        super(40, 4);
    }

    /**
     * Overridden method from superclass
     * implemented in a way to work properly for Vampire
     *
     * @param opponent object who can receive damage
     */
    @Override
    public void hit(CanReceiveDamage opponent) {

        int damageDealt = damageDealt(opponent);
        setHealth(getHealth() + damageDealt*VAMPIRISM/100);
    }


}
