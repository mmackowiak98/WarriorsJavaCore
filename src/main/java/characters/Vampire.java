package characters;

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

    private void setVampirism(int vampirism) {
        this.vampirism = vampirism;
    }

    public int getVampirism() {
        return vampirism;
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
        setHealth(getHealth() + damageDealt* vampirism /100);

    }

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        setVampirism(getVampirism()+ weapon.getVampirism());
    }


}
