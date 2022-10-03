package characters.characteristics;

@FunctionalInterface
public interface HasAttack {
    int getAttack();

    default void hit(CanReceiveDamage opponent) {

        opponent.receiveDamage(this);

    }
}
