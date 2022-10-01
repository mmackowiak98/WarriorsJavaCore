package game.smoke.tests;

import characters.weapons.Weapon;
import characters.weapons.Weapons;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import characters.*;
import game.Battle;

import static characters.weapons.Weapon.*;
import static characters.weapons.Weapons.*;

public class SmokeTestWeapons {

    @Test
    @DisplayName("Smoke Test The Weapons")
    public void smokeTest(){
        var ogre = new Warrior();
        var lancelot = new Knight();
        var richard = new Defender();
        var eric = new Vampire();
        var freelancer = new Lancer();
        var priest = new Healer();


        var sword = newSword();
        var shield = newShield();
        var axe = newGreatAxe();
        var katana = newKatana();
        var wand = newMagicWand();

        Weapon newSuperWeapon = newSuperWeapon();


        ogre.equipWeapon(sword);
        ogre.equipWeapon(shield);
        ogre.equipWeapon(newSuperWeapon);
        lancelot.equipWeapon(newSuperWeapon);
        richard.equipWeapon(shield);
        eric.equipWeapon(newSuperWeapon);
        freelancer.equipWeapon(axe);
        freelancer.equipWeapon(katana);
        priest.equipWeapon(wand);
        priest.equipWeapon(shield);

        assert ogre.getHealth() == 125;
        assert lancelot.getAttack() == 17;
        assert richard.getDefense() == 4;
        assert eric.getVampirism() == 200;
        assert freelancer.getHealth() == 15;
        assert priest.getHealingPwr() == 5;

        assert Battle.fight(ogre, eric) == false;
        assert Battle.fight(priest, richard) == false;
        assert Battle.fight(lancelot, freelancer) == true;

        var myArmy = new Army();
        myArmy.addUnits(Knight::new, 1);
        myArmy.addUnits(Lancer::new, 1);

        var enemyArmy = new Army();
        enemyArmy.addUnits(Vampire::new, 1);
        enemyArmy.addUnits(Healer::new, 1);

        myArmy.equipWarriorAtPosition(0, axe);
        myArmy.equipWarriorAtPosition(1, newSuperWeapon);

        enemyArmy.equipWarriorAtPosition(0, katana);
        enemyArmy.equipWarriorAtPosition(1, wand);

        assert Battle.armyFight(myArmy, enemyArmy) == true;
    }
}
