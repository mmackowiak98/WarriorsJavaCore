package game.damage.types;

import characters.Warrior;

public interface IDamage {
    Warrior getDamageDealer();
    int getValue();
}
