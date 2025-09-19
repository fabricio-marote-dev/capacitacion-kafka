package com.capacitacion.kafka.producer.producer;

import com.capacitacion.kafka.common.model.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;
    private final String topic;

    private static final Logger logger = LoggerFactory.getLogger(OrderProducer.class);

    public OrderProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate,
                         @Value("${app.kafka.topic}") String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }

    public void send(OrderEvent order) {
        kafkaTemplate.send(topic, order);
        logger.info("Orden publicada en el tópico "+ topic + " de Kafka: " + order.getId());
    }
}
