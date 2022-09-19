package characters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Supplier;



public class Army {

    private final Collection<Warrior> armyList = new ArrayList<>();

    /**
     * Method to add units to Collection
     * using Supplier interface
     *
     * @param warriorFactory - Supplier
     * @param amount - amount of units to be added
     * @return - Army
     */
    public Army addUnits(Supplier<Warrior> warriorFactory, int amount) { //Can be done with Cloneable interface too
        for (int i = 0; i < amount; i++) {
            armyList.add(warriorFactory.get());
        }
        return this;
    }

    public Warrior getSingleUnit(){
            return armyList.iterator().next();
    }
    public int size() {
        return armyList.size();
    }

    public void removeUnit(Warrior unitToRemove){
       armyList.remove(unitToRemove);
    }

    public boolean isNotEmpty(){
        return armyList.size()>0;
    }

}
