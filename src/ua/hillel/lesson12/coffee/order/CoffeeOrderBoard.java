package ua.hillel.lesson12.coffee.order;

import java.util.*;

public class CoffeeOrderBoard {
    private static int orderCount = 0;
    private Queue<Order> orderboard = new ArrayDeque<>();

    public void add(Order order) {
        orderCount += 1;
        order.setNumber(orderCount);
        this.orderboard.offer(order);
    }

    public void deliver() {
        System.out.println(this.orderboard.poll());
    }

    public void deliver(int numberOrder) {
        System.out.println(this.orderboard.remove(numberOrder));
    }

    public void draw() {
        System.out.println("Num  |      Name ");
        orderboard.iterator().forEachRemaining(System.out::println);
    }
}

