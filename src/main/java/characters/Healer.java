package characters;

public class Healer extends Warrior implements CanProcessCommand {

    private static final int HEALING_PWR = 2;

    public Healer() {
        super(60, 0);
    }


    @Override
    public void hit(CanReceiveDamage opponent) {
        //do nothing, healer not attacking
    }

    public void heal(Warrior allyWarrior) {
        allyWarrior.setHealth(allyWarrior.getHealth() + HEALING_PWR);
    }

    @Override
    public void processCommand(Command command, Warrior sender) {
        if(command instanceof HealCommand){
            heal(sender);
        }
    }
}
