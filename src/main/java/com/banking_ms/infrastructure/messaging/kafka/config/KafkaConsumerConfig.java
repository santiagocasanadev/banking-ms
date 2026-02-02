package com.banking_ms.infrastructure.messaging.kafka.config;

import com.banking_ms.infrastructure.messaging.kafka.dto.TransactionCreatedEvent;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
@ConditionalOnProperty(
        value = "kafka.enabled",
        havingValue = "true",
        matchIfMissing = false
)
public class KafkaConsumerConfig {

    @KafkaListener(topics = "transaction.created", groupId = "banking-ms")
    public void consume(TransactionCreatedEvent event) {
        System.out.println("Auditing transaction: " + event.transactionId());
    }
}
