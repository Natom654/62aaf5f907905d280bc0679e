import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CoffeOrder {

    private static final Logger log = LogManager.getLogger((CoffeOrder.class));

    private int orderCount = 0;
    private final Deque<Order> orderboard = new ArrayDeque<>();

    public void add(String name) {
        var order =new Order(orderboard.size()+1, name);
        log.info("New order [ number {}, for {} ] create", order.getNumberOrder(), order.getNameVisitor());
        try {
            orderboard.add(order);
        } catch (Exception e) {
            log.error("error is:", e);
        }
        log.info("Order [ number {}, for {} ] successful added", order.getNumberOrder(), order.getNameVisitor());
    }


    public Optional<Order> deliver() {
        var maybeOrder = orderboard.pollFirst();
        if (maybeOrder == null) {
            log.info("Nothing to deliver. The working board is empty");
            return Optional.empty();
        }

        log.info("Order [number {}, for {}] is ready to deliver", maybeOrder.getNumberOrder(), maybeOrder.getNameVisitor());
        return Optional.of(maybeOrder);
    }

    public void draw() {
        System.out.println("Num   |      Name ");
        orderboard.iterator().forEachRemaining(System.out::println);
    }


}

