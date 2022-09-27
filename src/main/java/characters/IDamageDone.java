package characters;

public interface IDamageDone extends HasAttack {
    default int damageDealt(CanReceiveDamage opponent) {
        int healthBefore = opponent.getHealth();
        HasAttack.super.hit(opponent);
        int healthAfter = opponent.getHealth();
        return healthBefore - healthAfter;
    }
}
