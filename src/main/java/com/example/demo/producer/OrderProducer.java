package com.example.demo.producer;

import com.example.demo.model.OrderEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;
    private final String topic;

    public OrderProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate,
                         @Value("${app.kafka.topic}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void send(OrderEvent order) {
        kafkaTemplate.send(topic, order);
        System.out.println("Orden enviada a Kafka: " + order.getId());
    }
}
