package com.banking_ms.infrastructure.messaging.kafka.config;

import com.banking_ms.infrastructure.messaging.kafka.dto.TransactionCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerConfig {

    @KafkaListener(topics = "transaction.created", groupId = "banking-ms")
    public void consume(TransactionCreatedEvent event) {
        System.out.println("Auditing transaction: " + event.transactionId());
    }
}
