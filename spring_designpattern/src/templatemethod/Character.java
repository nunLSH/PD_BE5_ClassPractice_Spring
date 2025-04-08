package templatemethod;

public interface Character {
    void attack(Character target);
    void takeDamage(int damage);
    boolean isDead();
}