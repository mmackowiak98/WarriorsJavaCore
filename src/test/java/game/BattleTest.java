package game;

import characters.Army;
import characters.Knight;
import characters.Warrior;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BattleTest {




    @Test
    @DisplayName("Smoke Test")
    void Smoke_Test() {
        var myArmy = new Army();
        myArmy.addUnits(Knight::new, 3);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior::new, 3);

        var army3 = new Army();
        army3.addUnits(Warrior::new, 20);
        army3.addUnits(Knight::new, 5);

        var army4 = new Army();
        army4.addUnits(Warrior::new, 30);

        assert Battle.armyFight(myArmy, enemyArmy);
        assert !Battle.armyFight(army3, army4);
    }

    @Test
    @DisplayName("1. Battle")
    void ArmyFight_False_SecondArmyWins() {
        Army army1 = new Army();
        Army army2 = new Army();


        army1.addUnits(Warrior::new, 1);
        army2.addUnits(Warrior::new, 2);

        assertFalse(Battle.armyFight(army1, army2));

    }

    @Test
    @DisplayName("2. Battle")
    void ArmyFight_False_SecondArmyWith1MoreWarriorWins() {
        Army army1 = new Army();
        Army army2 = new Army();


        army1.addUnits(Warrior::new, 2);
        army2.addUnits(Warrior::new, 3);

        assertFalse(Battle.armyFight(army1, army2));

    }

    @Test
    @DisplayName("3. Battle")
    void ArmyFight_False_SecondArmyWithTwoMoreWarriorWins() {
        Army army1 = new Army();
        Army army2 = new Army();


        army1.addUnits(Warrior::new, 5);
        army2.addUnits(Warrior::new, 7);

        assertFalse(Battle.armyFight(army1, army2));

    }

    @Test
    @DisplayName("4. Battle")
    void ArmyFight_True_FirstArmyWithLessWarriorsWins() {
        Army army1 = new Army();
        Army army2 = new Army();


        army1.addUnits(Warrior::new, 20);
        army2.addUnits(Warrior::new, 21);

        assertTrue(Battle.armyFight(army1, army2));

    }

    @Test
    @DisplayName("5. Battle")
    void ArmyFight_True_FirstArmyWins() {
        Army army1 = new Army();
        Army army2 = new Army();


        army1.addUnits(Warrior::new, 11);
        army2.addUnits(Warrior::new, 7);

        assertTrue(Battle.armyFight(army1, army2));

    }

    @Test
    @DisplayName("6. Battle")
    void ArmyFight_True_FirstArmyLessWarriorsWins() {
        Army army1 = new Army();
        Army army2 = new Army();


        army1.addUnits(Warrior::new, 10);
        army2.addUnits(Warrior::new, 11);

        assertTrue(Battle.armyFight(army1, army2));

    }

    @Test
    @DisplayName("7. Battle")
    void ArmyFight_False_SecondArmyWithKnightsWins() {
        Army army1 = new Army();
        Army army2 = new Army();


        army1.addUnits(Warrior::new, 5);
        army2.addUnits(Knight::new, 6);

        assertFalse(Battle.armyFight(army1, army2));

    }




    @ParameterizedTest
    @DisplayName("1. ParameterizedTest - ArmyFight")
    @MethodSource("provideWinningAttackingArmiesForArmyBattle")
    void ArmyFight_True_AttackingArmyWins(Army attackingArmy,
                                          Army defendingArmy,
                                          boolean expected) {

        assertEquals(expected, Battle.armyFight(attackingArmy, defendingArmy));

    }

    @ParameterizedTest
    @DisplayName("2. ParameterizedTest - ArmyFight")
    @MethodSource("provideWinningDefendingArmiesForArmyBattle")
    void ArmyFight_False_DefendingArmyWins(Army attackingArmy,
                                           Army defendingArmy,
                                           boolean expected) {

        assertEquals(expected, Battle.armyFight(attackingArmy, defendingArmy));

    }

    @ParameterizedTest
    @DisplayName("3. ParameterizedTest - ArmyFight")
    @MethodSource("provideWinningAttackingArmyWithKnightsForArmyBattle")
    void ArmyFight_True_AttackingArmyWithKnightsWin(Army attackingArmy,
                                                    Army defendingArmy,
                                                    boolean expected){
        assertEquals(expected, Battle.armyFight(attackingArmy, defendingArmy));
    }

    /* TODO - Parametrized tests with defenders and vampires in army!! */

    private static Stream<Arguments> provideWinningAttackingArmiesForArmyBattle() {

        return Stream.of(
                Arguments.of(
                        new Army().addUnits(Warrior::new, 20),
                        new Army().addUnits(Warrior::new, 21),
                        true),
                Arguments.of(
                        new Army().addUnits(Warrior::new, 10),
                        new Army().addUnits(Warrior::new, 11),
                        true),
                Arguments.of(
                        new Army().addUnits(Warrior::new, 11),
                        new Army().addUnits(Warrior::new, 7),
                        true)
        );

    }

    private static Stream<Arguments> provideWinningDefendingArmiesForArmyBattle() {

        return Stream.of(
                Arguments.of(
                        new Army().addUnits(Warrior::new, 1),
                        new Army().addUnits(Warrior::new, 2),
                        false),
                Arguments.of(
                        new Army().addUnits(Warrior::new, 2),
                        new Army().addUnits(Warrior::new, 3),
                        false),
                Arguments.of(
                        new Army().addUnits(Warrior::new, 5),
                        new Army().addUnits(Warrior::new, 7),
                        false)
        );

    }

    public static Stream<Arguments> provideWinningAttackingArmyWithKnightsForArmyBattle() {
        return Stream.of(
                Arguments.of(
                        new Army().addUnits(Knight::new, 2),
                        new Army().addUnits(Knight::new, 2),
                        true),
                Arguments.of(
                        new Army().addUnits(Knight::new, 5),
                        new Army().addUnits(Knight::new, 3),
                        true),
                Arguments.of(
                        new Army().addUnits(Knight::new, 8),
                        new Army().addUnits(Knight::new, 7),
                        true)
        );
    }


}
