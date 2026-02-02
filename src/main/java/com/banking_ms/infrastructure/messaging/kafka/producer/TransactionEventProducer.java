package com.banking_ms.infrastructure.messaging.kafka.producer;

import com.banking_ms.infrastructure.messaging.kafka.dto.TransactionCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/*
* Este adaptador traduce un hecho del dominio a un evento Kafka.
*/
@Component
public class TransactionEventProducer {
    private static final String TOPIC = "transaction.created";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public TransactionEventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(TransactionCreatedEvent event) {
        kafkaTemplate.send(TOPIC, event.transactionId().toString(), event);
    }
}
