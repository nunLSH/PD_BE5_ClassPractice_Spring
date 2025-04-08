package strategy.weapon;

public interface Weapon {
    int calcWeaponWeight(int damage);
    void attack();
    String getName();
}