package characters.characteristics;


public interface CanReceiveDamage extends HasHealth {
    void receiveDamage(HasAttack damager);

}
