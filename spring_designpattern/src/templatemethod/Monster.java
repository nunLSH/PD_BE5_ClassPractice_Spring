package templatemethod;

public class Monster extends AbstractCharacter{

    public Monster(String name, int hp, int atk, int def) {
        super(name, hp, atk, def);
    }

    @Override
    protected int calAtkWeight(int damage) {
        return damage;
    }

    @Override
    protected int calDefWeight(int damage) {
        return damage;
    }
}