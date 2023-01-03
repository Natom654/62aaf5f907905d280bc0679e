package cart;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Service
@Scope("prototype")
public class Cart {

    ProductRepository productRepository;
    private final Map<Product, Integer> cartMap = new HashMap<>();

    public Map<Product, Integer> getCartMap() {
        return cartMap;
    }
    public void addProductToCart(Product product, Integer quantity) {
        if (product != null)
            cartMap.put(product, quantity);
    }

    public void removeProductFromCart(Product product, Integer quantity) {
        if (cartMap.containsKey(product)) {
            if (quantity != null && cartMap.get(product).compareTo(quantity) > 0) {
                cartMap.put(product, cartMap.get(product) - quantity);
            } else {
                cartMap.remove(product);
            }
        }
    }
    public void addToCartByID(int id, Integer quantity) {
       Product product= productRepository.findById(id);
        this.addProductToCart( product, quantity);
    }

    @Override
    public String toString() {
        return "Cart" + this.hashCode() + getCartMap();
    }
}
