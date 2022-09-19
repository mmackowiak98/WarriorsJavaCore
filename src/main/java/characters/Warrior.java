package characters;

/**
 * Maciej Maćkowiak 14.09.2022
 * Class responsible for implementing object Warrior
 */
public class Warrior implements Cloneable {

    private int health;
    private int attack;



    /**
     * Constructor of Warrior
     *
     * @param health - health of Warrior
     * @param attack - attack of Warrior
     */
    public Warrior(int health, int attack) {
        this.health = health;
        this.attack = attack;
    }

    /**
     * Overloaded constructor of Warrior
     */
    public Warrior() {
        this(50,5);
    }

    /**
     * Implementing clone method from Cloneable interface
     * to add units
     *
     * @return returns cloned object
     */
    @Override
    protected Warrior clone() {
        try {
            return (Warrior) super.clone();
        } catch (CloneNotSupportedException e) {
            //nothing here
        }
        throw new IllegalStateException("Oops!");
    }

    /**
     * Method to check if object health is >0
     *
     * @return true or false, depends on if object field health is >0 or <0
     */
    public boolean isAlive() {
        return health > 0;
    }


    /**
     * Method implements hitting opponent
     *
     * @param opponent object who's hitting
     */
    public void hit(Warrior opponent) {
        opponent.receiveDamage(getAttack());

    }

    /**
     * Method implements receiving
     * damage from opponent
     *
     * @param attack amount of health to take away
     */
    int receiveDamage(int attack) {
        setHealth(getHealth() - attack);
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }


    public void setHealth(int health) {
        this.health = health;
    }


}
