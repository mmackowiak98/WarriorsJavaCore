package game;

import characters.Knight;
import characters.Warrior;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BattleTest {


    @Test
    @DisplayName("1. Fight")
    void Fight_False_SecondWarriorAsKnightWins() {
        var war1 = new Warrior();
        var war2 = new Knight();

        var res = Battle.fight(war1, war2);
        assertFalse(res);

    }

    @Test
    @DisplayName("2. Fight")
    void Fight_True_FirstWarriorKnightWins() {

        var war1 = new Knight();
        var war2 = new Warrior();

        final boolean res = Battle.fight(war1, war2);
        assertTrue(res);

    }

    @Test
    @DisplayName("3. Fight")
    void Fight_True_FirstWarriorIsAlive() {
        var war1 = new Warrior();
        var war2 = new Warrior();

        Battle.fight(war1, war2);
        assertTrue(war1.isAlive());
    }

    @Test
    @DisplayName("4. Fight")
    void Fight_True_FirstWarriorAsKnightIsAlive() {
        var war1 = new Knight();
        var war2 = new Warrior();

        Battle.fight(war1, war2);
        assertTrue(war1.isAlive());
    }

    @Test
    @DisplayName("5. Fight")
    void Fight_False_SecondWarriorIsNotAlive() {
        var war1 = new Warrior();
        var war2 = new Warrior();

        Battle.fight(war1, war2);
        assertFalse(war2.isAlive());
    }

    @Test
    @DisplayName("6. Fight")
    void Fight_True_SecondWarriorAsKnightIsAlive() {
        var war1 = new Warrior();
        var war2 = new Knight();

        Battle.fight(war1, war2);
        assertTrue(war2.isAlive());
    }

    @Test
    @DisplayName("7. Fight")
    void Fight_False_WarriorFightKnightThenKnightFightNewWarrior() {
        var war1 = new Warrior();
        var war2 = new Knight();
        var war3 = new Warrior();

        Battle.fight(war1, war2);
        final boolean res = Battle.fight(war2, war3);

        assertFalse(res);
    }

}
