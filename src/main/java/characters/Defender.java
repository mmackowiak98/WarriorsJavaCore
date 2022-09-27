package characters;


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
     * @param damager object who has attack and can do damage
     */
    @Override
    public void receiveDamage(HasAttack damager) {
        int finalDamage = Math.max(0, damager.getAttack()-getDefense());

        super.receiveDamage(() -> finalDamage);

    }
}
