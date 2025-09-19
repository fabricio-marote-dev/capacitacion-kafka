package com.example.demo.controller;

import com.example.demo.model.OrderEvent;
import com.example.demo.producer.OrderProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderProducer producer;

    public OrderController(OrderProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public String createOrder(@RequestBody OrderEvent order) {
        producer.send(order);
        return "Orden enviada: " + order.getId();
    }
}
