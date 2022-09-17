package ua.hillel.lesson12.coffee.order;

public class Order {
    private int numberOrder;
    private String nameVisitor;

    public Order(String nameVisitor) {
        this.nameVisitor = nameVisitor;
    }

    public void setNumber(int number) {
        this.numberOrder = number;
    }

    @Override
    public String toString() {
        return numberOrder + "   |    " +
                nameVisitor;
    }
}