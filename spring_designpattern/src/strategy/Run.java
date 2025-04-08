package strategy;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import strategy.character.Beginner;
import strategy.character.Character;
import strategy.character.Monster;
import strategy.character.Player;
import strategy.character.Warrior;
import strategy.weapon.Gun;
import strategy.weapon.Sword;
import strategy.weapon.Weapon;

public class Run {

    public static void main(String[] args) {
        Player beginner = new Beginner("초보자", 100, 20, 10);
        Player warrior = new Warrior("전사", 100, 20, 10);
        battle(warrior);
    }

    private static void battle(Player player) {
        Scanner sc = new Scanner(System.in);
        Monster monster = new Monster("슬라임", 1000, 20, 10);
        System.out.println(monster.getName() + " 등장했습니다.");

        List<Weapon> weapons = List.of(
            new Sword("동검", 10),
            new Sword("철검", 15),
            new Sword("강철검", 20),
            new Gun("소총", 20),
            new Gun("권총", 10)
        );

        while (true){
            if(player.isDead()){
                System.out.println("system: 패배");
                break;
            }

            if(monster.isDead()){
                System.out.println("system: 승리하였습니다.");
                break;
            }

            System.out.println("\n====================");
            sc.nextLine();

            Random random = new Random();
            int itemIdx = random.nextInt(0, 5);
            player.equippedWeapon(weapons.get(itemIdx));

            player.attack(monster);
            monster.attack(player);
        }
    }
}
