package characters.weapons;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Weapon implements Weapons {
    private int attack;
    private int health;
    private int defense;
    private int vampirism;
    private int health_power;

}

