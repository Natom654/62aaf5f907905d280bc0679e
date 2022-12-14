import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @NonNull
    private int numberOrder;
    @NonNull
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