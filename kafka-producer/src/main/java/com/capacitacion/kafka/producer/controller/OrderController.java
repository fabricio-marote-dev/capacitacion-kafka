package com.capacitacion.kafka.producer.controller;

import com.capacitacion.kafka.common.model.OrderEvent;
import com.capacitacion.kafka.producer.producer.OrderProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderProducer orderProducer;

    public OrderController(OrderProducer producer) {
        this.orderProducer = producer;
    }

    @PostMapping
    public String createOrder(@RequestBody OrderEvent order) {
        orderProducer.send(order);
        return "Orden publicada en Kafka: " + order.getId();
    }
}
