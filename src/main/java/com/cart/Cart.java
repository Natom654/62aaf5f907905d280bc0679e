package com.cart;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Service
@Scope("prototype")
public class Cart {

    ProductRepository productRepository;
    Map<Product, Integer> cartMap = new HashMap<>();

    public Map<Product, Integer> getCartMap() {
        return cartMap;
    }

    public void addProductToCart(Product product, int quantity) {
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

    public void addToCartByID(int id, int quantity) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            product.get();
        }
    }

    @Override
    public String toString() {
        return "Cart" + this.hashCode() + getCartMap();
    }
}
