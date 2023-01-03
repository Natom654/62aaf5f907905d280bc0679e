package cart;

import cart.Cart;
import cart.Product;
import cart.ProductRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CartApplication {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext("cart");
        System.out.println(ctx.getBean(Cart.class));

        ProductRepository productRepository = new ProductRepository();
        productRepository.addProduct(new Product(1, "banan", 35.5f));
        productRepository.addProduct(new Product(2, "orange", 42.3f));
        productRepository.addProduct(new Product(3, "kiwi", 5.5f));
        productRepository.addProduct(new Product(4, "apple", 10.0f));

        productRepository.removeProduct(new Product(4, "apple", 10.0f));

        System.out.println("List of all products: ");
        productRepository.getAllProducts();


        System.out.println("Enter the id of product");
        Scanner scan = new Scanner(System.in);
        int choiceProduct = scan.nextInt();

        System.out.println("You choose " + productRepository.findById(choiceProduct));


        System.out.println("Enter the id of product, that you want to put in Cart");

        System.out.println(ctx.getBean(Cart.class));
        Cart productOnCart = new Cart(productRepository);
        Scanner scanCart = new Scanner(System.in);
        int choiceProductToCart = scanCart.nextInt();

        System.out.println("Enter the quantity of product, that you want to put in Cart");
        int quantityOfProducts = scanCart.nextInt();
        productOnCart.addToCartByID(choiceProductToCart, quantityOfProducts);
        System.out.println("You put to the cart " + productOnCart);
    }
}

