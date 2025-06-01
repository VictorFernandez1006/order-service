package com.coudevi.application.kafka;

import com.coudevi.domain.event.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerService {
    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public void sendOrderCreatedEvent(OrderCreatedEvent orderCreatedEvent){
        log.info("Sending Kafka event: {}", orderCreatedEvent);
        kafkaTemplate.send("orders-topic", orderCreatedEvent);
    }

}
