package characters;


/**
 * Maciej Maćkowiak 19.09.2022
 * <p>
 * Class responsible for implementing object Defender
 */
public class Defender extends Warrior {

    private final int defense;

    public Defender() {
        super(60, 3);
        this.defense = 2;
    }

    /**
     *
     * @param attack amount of health to take away
     * @return
     */
    @Override
    int receiveDamage(int attack) {
        int finalDamage = attack - defense;

        if (attack < defense) {
            super.receiveDamage(0);
        } else {
            super.receiveDamage(finalDamage);
        }
        return finalDamage;
    }
}
