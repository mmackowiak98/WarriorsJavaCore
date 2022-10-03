package characters;


import characters.characteristics.HasAttack;
import characters.weapons.Weapon;

/**
 * Maciej Maćkowiak 19.09.2022
 *
 * Class responsible for implementing object Defender
 */
public class Defender extends Warrior {

    private int defense = 2;

    public Defender() {
        super(60, 3);
    }

    public int getDefense(){
        return defense;
    }

    private void setDefense(int defense) {
        this.defense = defense;
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

    @Override
    public void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        setDefense(getDefense()+ weapon.getDefense());
    }
}
