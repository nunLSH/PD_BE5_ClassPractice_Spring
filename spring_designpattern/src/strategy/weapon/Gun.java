package strategy.weapon;

public class Gun implements Weapon{

    private String name;
    private int atk;

    public Gun(String name, int atk) {
        this.name = name;
        this.atk = atk;
    }

    @Override
    public int calcWeaponWeight(int damage) {
        return damage + atk * 3;
    }

    @Override
    public void attack() {
        System.out.println(name + "을 쏩니다. 빵야빵야");
    }

    @Override
    public String getName() {
        return name;
    }
}