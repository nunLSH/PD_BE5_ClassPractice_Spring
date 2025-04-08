package strategy.character;

public class Warrior extends Player {

    public Warrior(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    @Override
    protected int calClassWeight(int damage) {
        return (int) (damage * 1.5);
    }

    @Override
    protected int calDefWeight(int damage) {
        return (int) (damage * 0.5);
    }
}