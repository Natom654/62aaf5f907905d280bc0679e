package ua.hillel.homework.lesson11.fruit;

public final class Apple implements Fruit {
    private static final double WEIGHT = 1.0;

    @Override
    public double getWeight() {
        return WEIGHT;
    }
}