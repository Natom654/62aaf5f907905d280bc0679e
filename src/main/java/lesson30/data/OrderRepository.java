package lesson30.data;

import lesson30.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Optional<Order> findById(long id);
    List<Order> findAll();
    void add(Order order);
}
