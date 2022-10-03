package characters.characteristics;

public interface HasHealth {
    int getHealth();

    void setHealth(int health);

    default boolean isAlive() {
        return getHealth() > 0;
    }
}
