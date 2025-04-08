package templatemethod;

public class Warrior extends AbstractCharacter{

    public Warrior(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    @Override
    protected int calAtkWeight(int damage) {
        return (int) (damage * 1.5);
    }

    @Override
    protected int calDefWeight(int damage) {
        return (int) (damage * 0.5);
    }
}