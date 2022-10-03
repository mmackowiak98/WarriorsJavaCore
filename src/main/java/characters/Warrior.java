package characters;


import characters.characteristics.CanEquipWeapon;
import characters.characteristics.CanReceiveDamage;
import characters.characteristics.HasAttack;
import characters.characteristics.HasHealth;
import characters.weapons.Weapon;
import lombok.Getter;


/**
 * Maciej Maćkowiak 14.09.2022
 * Class responsible for implementing object Warrior
 */

@Getter
public class Warrior implements HasHealth, HasAttack, CanReceiveDamage, CanEquipWeapon {
    private int health;
    private int attack;
    private int initialHealth;


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
    public void equipWeapon(Weapon weapon) {
        initialHealth = initialHealth + weapon.getHealth();
        setHealth(initialHealth);
        setAttack(getAttack() + weapon.getAttack());

    }

    @Override
    public void setHealth(int health) {
        this.health = Math.min(health, initialHealth);
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }


}
