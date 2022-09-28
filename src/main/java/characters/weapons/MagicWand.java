package characters.weapons;

public class MagicWand extends Weapon {
    private int heal_pwr = 3;
    public MagicWand(){
        super(3,30);
    }

    public int getHeal_pwr() {
        return heal_pwr;
    }

}
