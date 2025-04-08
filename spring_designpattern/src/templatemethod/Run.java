package templatemethod;

import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
        Character beginner = new Beginner("초보자", 100, 20, 10);
        Character warrior = new Warrior("전사", 100, 20, 10);
        battle(warrior);
    }

    private static void battle(Character player) {
        Scanner sc = new Scanner(System.in);
        Monster monster = new Monster("슬라임", 100, 20, 10);
        System.out.println(monster.getName() + " 등장했습니다.");

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

            player.attack(monster);
            monster.attack(player);
        }
    }
}