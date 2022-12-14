public class Application {
    public static void main(String[] args) {
        CoffeOrder cofeorderboard = new CoffeOrder();
        cofeorderboard.add("Alen");
        cofeorderboard.add("Tom");
        cofeorderboard.add("Masha");
        cofeorderboard.add("Kate");
        cofeorderboard.deliver();
        cofeorderboard.add("Dan");
        cofeorderboard.add("Samuel");
        cofeorderboard.deliver();
        cofeorderboard.draw();
        cofeorderboard.deliver();
        cofeorderboard.draw();
    }
}
