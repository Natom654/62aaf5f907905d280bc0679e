package ua.hillel.lesson12.coffee.order;

import java.util.ArrayDeque;
import java.util.Deque;

public class Application {
    public static void main(String[] args) {
        CoffeeOrderBoard orderboard = new CoffeeOrderBoard();

        Order order = new Order("Alen");
        Order order1 = new Order("Tom");
        Order order2 = new Order("Masha");
        Order order3 = new Order("Kate");
        Order order4 = new Order("Sam");
        Order order5 = new Order("Samuel");
        Order order6 = new Order("Dan");

        orderboard.add(order);
        orderboard.add(order1);
        orderboard.add(order2);
        orderboard.add(order3);
        orderboard.add(order4);

        orderboard.draw();

        orderboard.deliver();
        orderboard.add(order5);
        orderboard.add(order6);
        orderboard.deliver();
        orderboard.draw();

        orderboard.deliver(5);
        orderboard.draw();
    }
}

