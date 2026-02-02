package com.banking_ms.infrastructure.observability.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class TransactionMetrics {

    private final Counter transactionCreated;
    private final Counter transactionFailed;

    public TransactionMetrics(MeterRegistry registry) {
        this.transactionCreated = Counter.builder("banking.transaction.created")
                .description("Total transactions created")
                .register(registry);
        this.transactionFailed = Counter.builder("banking.transaction.failed")
                .description("Total transactions failed")
                .register(registry);
    }

    public void incrementCreated() {
        transactionCreated.increment();
    }

    public void incrementFailed() {
        transactionFailed.increment();
    }

}
