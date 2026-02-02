package com.banking_ms.infrastructure.messaging.kafka.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record TransactionCreatedEvent(
        UUID transactionId,
        UUID accountId,
        BigDecimal amount,
        String type,
        Instant occurredAt
) {}
