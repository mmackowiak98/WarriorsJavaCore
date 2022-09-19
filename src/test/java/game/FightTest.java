package game;

import characters.Defender;
import characters.Knight;
import characters.Warrior;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FightTest {

    private class Rookie extends Warrior {

         Rookie() {
            super(50,1);
        }
    }


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
    void Fight_True_FirstWarriorAsKnightWins() {

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

    @Test
    @DisplayName("1. Is alive")
    void isAlive_True_WarriorIsAlive(){
        var war1 = new Warrior();
        assertTrue(war1.isAlive());
    }

    @Test
    @DisplayName("2. Is alive")
    void isAlive_True_KnightIsAlive(){
        var war1 = new Knight();
        assertTrue(war1.isAlive());
    }

    @Test
    @DisplayName("8. Fight with Defenders")
    void receiveDamage_True_HealthStayTheSame(){
        var def1 = new Defender();
        var rok1 = new Rookie();

        Battle.fight(def1,rok1);

        assertEquals(60,def1.getHealth());

    }

    @Test
    @DisplayName("9. Fight with Defenders")
    void Fight_True_DefenderFightsRookieThenWarriorAndWin(){

        var def1 = new Defender();
        var rok1 = new Rookie();
        var war1 = new Warrior();

        Battle.fight(def1,rok1);
        final boolean result = Battle.fight(def1, war1);

        assertTrue(result);
    }

    @Test
    @DisplayName("10. Fight with Defenders")
    void Fight_True_DefenderFightsWarriorAndWin(){

        var def1 = new Defender();
        var war1 = new Warrior();

        final boolean result = Battle.fight(def1, war1);

        assertTrue(result);
    }

    @Test
    @DisplayName("11. Fight with Defenders")
    void Fight_True_WarriorFightsDefenderAndLose(){

        var def1 = new Defender();
        var war1 = new Warrior();

        final boolean result = Battle.fight(war1,def1);

        assertFalse(result);
    }
    @Test
    @DisplayName("12. Fight with Defenders")
    void Fight_True_DefenderFightsDefenderFirstDefenderWin(){

        var def1 = new Defender();
        var def2 = new Defender();

        final boolean result = Battle.fight(def1,def2);

        assertTrue(result);
    }

    @Test
    @DisplayName("13. Fight with Defenders")
    void Fight_True_DefenderFightsKnightAndLose(){

        var def1 = new Defender();
        var kng1 = new Knight();

        final boolean result = Battle.fight(def1,kng1);

        assertFalse(result);
    }



}
