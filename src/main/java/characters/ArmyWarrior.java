package characters;


import java.util.Optional;

public interface ArmyWarrior extends CanProcessCommand {

    Warrior getWrapped();
    Warrior getWarriorBehind();
    boolean hasNext();
    Warrior next();

    default void processCommand(Command command, Warrior sender){
        if(getWrapped() instanceof CanProcessCommand warrior){
            warrior.processCommand(command, sender);
        }
        Optional.ofNullable(getWarriorBehind()).get();
    }

}

interface CanProcessCommand {
    void processCommand(Command command, Warrior sender );
}

interface Command{}

interface HealCommand extends Command{}