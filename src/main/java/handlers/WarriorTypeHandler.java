package handlers;

import characters.Army;
import characters.Lancer;
import characters.Warrior;

import java.util.Iterator;

public class WarriorTypeHandler extends Handler {
    private Army army;

    public WarriorTypeHandler(Army army) {
        this.army = army;
    }


    @Override
    public boolean handle(Warrior warrior) {
        final Iterator<Warrior> warriorIterator = army.firstAlive();
        return warriorIterator instanceof Lancer;
    }
}



