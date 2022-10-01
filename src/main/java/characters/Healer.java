package characters;

import characters.weapons.Weapon;

public class Healer extends Warrior{

    private int healingPwr = 2;

    public Healer() {
        super(60, 0);
    }


    public int getHealingPwr() {
        return healingPwr;
    }

    private void setHealingPwr(int healingPwr) {
        this.healingPwr = healingPwr;
    }

    public void heal(Warrior allyWarrior) {
        allyWarrior.setHealth(allyWarrior.getHealth() + healingPwr);
    }


    @Override
    public void equipWeapon(Weapon weapon) {
        setHealth(getHealth() + weapon.getHealth());
        setHealingPwr(getHealingPwr() + weapon.getHealth_power());
    }
}
