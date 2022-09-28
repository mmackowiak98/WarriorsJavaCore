package characters.weapons;

public class Weapon {
    private int attack;
    private int health;

    protected Weapon(int attack, int health) {
        this.attack = attack;
        this.health = health;
    }

    public Weapon() {
    }

    public int getAttack() {
        return attack;
    }

    public int getHealth() {
        return health;
    }
}
