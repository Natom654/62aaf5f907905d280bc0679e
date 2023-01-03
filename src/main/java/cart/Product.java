package cart;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Product {
    private int id = 0;
    private String name;
    private Float price;

    public Product(int id, String name, Float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id+1;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
