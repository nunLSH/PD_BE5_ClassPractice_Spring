package strategy.weapon;

public class Sword implements Weapon{

    private String name;
    private int atk;

    public Sword(String name, int atk) {
        this.name = name;
        this.atk = atk;
    }

    @Override
    public int calcWeaponWeight(int damage) {
        return (int) (damage + atk * 1.2);
    }

    @Override
    public void attack() {
        System.out.println(name + "을 날카롭게 휘두릅니다. 쉭쉭");
    }

    @Override
    public String getName() {
        return name;
    }
}