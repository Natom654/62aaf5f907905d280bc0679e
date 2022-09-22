package ua.hillel.lesson12.coffee.order;

import java.util.ArrayDeque;
import java.util.Deque;

public class Application {
    public static void main(String[] args) {
        CoffeeOrderBoard orderboard = new CoffeeOrderBoard();
        orderboard.add("Alen");
        orderboard.add("Tom");
        orderboard.add("Masha");
        orderboard.add("Kate");
        orderboard.add("Sam");
        orderboard.deliver();
        orderboard.add("Dan");
        orderboard.add("Samuel");
        orderboard.deliver();
        orderboard.draw();
        orderboard.deliver(5);
        orderboard.draw();
    }
}

