package characters;

import game.damage.types.PiercingDamage;

public class Lancer extends Warrior{

    public Lancer() {
        super(50,6);
    }

    @Override
    public void hit(Warrior opponent) {

        opponent.receiveDamage(new PiercingDamage(getAttack(),this));
    }
}
