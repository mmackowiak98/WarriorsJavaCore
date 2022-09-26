package characters;


interface HasHealth {
    int getHealth();

    void setHealth(int health);

    default boolean isAlive() {
        return getHealth() > 0;
    }
}


@FunctionalInterface
interface HasAttack{
    int getAttack();

    default void hit(CanReceiveDamage opponent) {

        opponent.receiveDamage(this);

    }
}

interface CanReceiveDamage extends HasHealth{
    void receiveDamage(HasAttack damager);

}

/**
 * Maciej Maćkowiak 14.09.2022
 * Class responsible for implementing object Warrior
 */
public class Warrior implements HasHealth, HasAttack, CanReceiveDamage{
    private int health;
    private final int attack;
    private final int initialHealth;


    /**
     * Constructor of Warrior
     *
     * @param health - health of Warrior
     * @param attack - attack of Warrior
     */
    protected Warrior(int health, int attack) {
        initialHealth = this.health = health;
        this.attack = attack;
    }

    /**
     * Overloaded constructor of Warrior
     */
    public Warrior() {
        this(50, 5);
    }

    @Override
    public void receiveDamage(HasAttack damager) {
        setHealth(getHealth() - damager.getAttack());

    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public void setHealth(int health) {
        this.health = Math.min(health, initialHealth);
    }


}
