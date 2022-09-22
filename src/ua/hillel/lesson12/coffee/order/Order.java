package ua.hillel.lesson12.coffee.order;

public class Order {
    private int numberOrder;
    private String nameVisitor;

    public Order(int numberOrder, String nameVisitor) {
        this.numberOrder = numberOrder;
        this.nameVisitor = nameVisitor;
    }

    public int getNumberOrder() {
        return numberOrder;
    }

    @Override
    public String toString() {
        return numberOrder + "   |    " +
                nameVisitor;
    }
}