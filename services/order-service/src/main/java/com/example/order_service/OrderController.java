package com.example.order_service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderRepository orderRepository;
    private final KafkaTemplate<String, Order> kafkaTemplate;

    public OrderController(OrderRepository orderRepository, KafkaTemplate<String, Order> kafkaTemplate) {
        this.orderRepository = orderRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public String placeOrder(@RequestBody Order order) {
        orderRepository.save(order);
        kafkaTemplate.send("order-placed", order);

        return "Order Placed Successfully";
    }
}
