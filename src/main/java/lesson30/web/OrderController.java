package lesson30.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import lesson30.data.OrderRepository;
import lesson30.entity.Order;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Order findById(@PathVariable long id) {
        return orderRepository.findById(id).orElseThrow();
    }

    @GetMapping
    @ResponseBody
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
