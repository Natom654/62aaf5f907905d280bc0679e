package com.cart;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository{

    private  List<Product> productRepository = new ArrayList<>();


    public void addProduct (Product product){
        productRepository.add(product);
    }

    public void removeProduct (Product product){
        productRepository.remove(product);
    }


    public Optional <Product> findById (int id) {
        for (Product product : productRepository) {
            if (product.getId () == id) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public List <Product> getAllProducts() {
       productRepository.forEach(product -> System.out.println(product));
       return productRepository;
    }
}
