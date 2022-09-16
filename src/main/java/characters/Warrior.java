package characters;

/**
 * Maciej Maćkowiak 14.09.2022
 * Class responsible for implementing object Warrior
 */
public class Warrior {

    private int health;
    private final int attack;


    /**
     * Constructor of Warrior
     * @param health - health of Warrior
     * @param attack - attack of Warrior
     */
    protected Warrior(int health, int attack) {
        this.health = health;
        this.attack = attack;
    }

    /**
     * Overloaded constructor of Warrior
     */
    public Warrior() {
        this(50, 5);
    }

    /**
     * Method to check if object health is >0
     * @return true or false, depends on if object field health is >0 or <0
     */
    public boolean isAlive() {
        return health >= 0;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

}
