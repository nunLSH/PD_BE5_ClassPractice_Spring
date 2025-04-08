package strategy.character;

public interface Character {
    void attack(Character target);
    void takeDamage(int damage);
    boolean isDead();
}