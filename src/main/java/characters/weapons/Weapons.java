package characters.weapons;

public interface Weapons {
    int getAttack();
    int getHealth();
    int getVampirism();
    int getDefense();
    int getHealth_power();

    static Weapon newSword(){
        return new Weapon.WeaponBuilder().attack(2).health(5).build();
    }
    static Weapon newShield(){
        return new Weapon.WeaponBuilder().attack(-1).health(20).defense(2).build();
    }
}
