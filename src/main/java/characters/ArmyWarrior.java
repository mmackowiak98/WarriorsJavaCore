package characters;


import java.util.Optional;

public interface ArmyWarrior {

    Warrior getWarriorBehind();

    boolean hasNext();

    Warrior next();

}


