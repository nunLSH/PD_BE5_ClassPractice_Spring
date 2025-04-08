package strategy.character;

import strategy.weapon.Weapon;

public abstract class Player extends AbstractCharacter{

    protected Weapon weapon;

    public Player(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    @Override
    protected int calAtkWeight(int damage){
        if(weapon == null) return damage;
        weapon.attack();
        damage = calClassWeight(damage);
        return damage + weapon.calcWeaponWeight(damage);
    }

    abstract int calClassWeight(int damage);

    public void equippedWeapon(Weapon weapon){
        System.out.println(weapon.getName() + " 착용했습니다.");
        this.weapon = weapon;
    }
}