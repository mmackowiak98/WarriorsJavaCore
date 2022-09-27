package characters;

public class Dragon extends Warrior {
    private static final int FIRE_BREATH_MASS_DAMAGE = 10;
    private int rounds = 0;

    public Dragon() {
        super(50, 0);
    }

    @Override
    public void hit(CanReceiveDamage opponent) {
        rounds++;
        if(opponent instanceof ArmyWarrior armyUnit && rounds==3){
                if(armyUnit.hasNext()) {
                    armyUnit.next().receiveDamage(() -> FIRE_BREATH_MASS_DAMAGE);
                }
        }
    }
}
