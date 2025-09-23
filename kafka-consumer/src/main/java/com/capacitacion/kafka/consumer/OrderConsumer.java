package com.capacitacion.kafka.consumer;

import com.capacitacion.kafka.common.model.OrderEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class OrderConsumer {

    private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "${app.kafka.topic}", groupId = "${app.kafka.consumer.groupId}", concurrency = "${app.kafka.consumer.consumersCount}")
    public void consume(OrderEvent message) throws JsonProcessingException {
        String json = objectMapper.writeValueAsString(message);
        logger.info("Mensaje recibido en [{}]: {}", Thread.currentThread().getName(), message);
    }
}
