package strategy.character;

public class Beginner extends Player {

    public Beginner(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    @Override
    protected int calClassWeight(int damage) {
        return (int) (damage * 1.1);
    }

    @Override
    protected int calDefWeight(int damage) {
        return (int) (damage * 0.9);
    }
}