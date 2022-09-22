package ua.hillel.lesson12.coffee.order;

import java.util.*;

public class CoffeeOrderBoard {
    private int orderCount;
    private Deque<Order> orderboard = new ArrayDeque<>();

    public void add(String name) {
        orderboard.addLast(new Order(++orderCount, name));
    }

    public Order deliver() {
        return orderboard.removeFirst();
    }

    public Order deliver(int numberOrder) {
        orderboard.stream()
                .filter(order -> order.getNumberOrder() == numberOrder)
                .findFirst()
                .orElseThrow();
        return orderboard.removeFirst();
    }

    public void draw() {
        System.out.println("Num  |      Name ");
        orderboard.iterator().forEachRemaining(System.out::println);
    }
}

