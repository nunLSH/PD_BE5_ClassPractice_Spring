package proxy;

import java.net.http.WebSocket;

public class Run {

    public static void main(String[] args) {

        Man man = new Man();
        Woman woman = new Woman();
        Child child = new Child();

        man.develop();
        System.out.println("============================");

        woman.develop();
        System.out.println("============================");

        child.develop();
        System.out.println("============================");
    }
}
