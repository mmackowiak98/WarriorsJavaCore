package characters.weapons;

public class Shield extends Weapon{
    private final int defense = 2;

    public Shield(){
        super(-1,20);
    }

    public int getDefense() {
        return defense;
    }
}
