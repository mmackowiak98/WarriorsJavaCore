package characters;

public class Vampire extends Warrior {
    private final int vampirism;

    public Vampire() {
        super(40, 4);
        this.vampirism = 50;
    }

    @Override
    public void hit(Warrior opponent) {

        if (this.getHealth() < 40) {

            final int damageDealt = opponent.receiveDamage(getAttack());
            this.setHealth(getHealth() + damageDealt * vampirism / 100);

            if (this.getHealth() > 40) {
                setHealth(40);
            }
        } else {
            super.hit(opponent);
        }

    }




}
