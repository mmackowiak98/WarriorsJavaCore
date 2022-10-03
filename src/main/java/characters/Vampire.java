package characters;

import characters.characteristics.CanReceiveDamage;
import characters.characteristics.IDamageDone;
import characters.weapons.Weapon;

/**
 * Maciej Maćkowiak 19.09.2022
 * <p>
 * Class responsible for implementing object Vampire
 */
public class Vampire extends Warrior implements IDamageDone {

    private int vampirism = 50;

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
        setHealth(getHealth() + damageDealt * vampirism / 100);

    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        this.vampirism = vampirism + weapon.getVampirism();
    }

    public int getVampirism() {
        return vampirism;
    }

    public void setVampirism(int vampirism){
        this.vampirism = vampirism;
    }

}
