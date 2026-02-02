package com.banking_ms.application.service;

import com.banking_ms.application.port.out.TransactionRepositoryPort;
import com.banking_ms.infrastructure.messaging.kafka.producer.TransactionEventProducer;
import com.banking_ms.infrastructure.observability.metrics.TransactionMetrics;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TransactionApplicationServiceTest {

    private final TransactionRepositoryPort repository =
            Mockito.mock(TransactionRepositoryPort.class);

    private final TransactionEventProducer producer =
            Mockito.mock(TransactionEventProducer.class);

    private final TransactionMetrics metrics =
            Mockito.mock(TransactionMetrics.class);

    @Test
    void shouldPublishEventAndIncrementMetric() {
        // arrange
        // Transaction transaction = ...

        // act
        // service.createTransaction(transaction);

        // assert
        Mockito.verify(producer).publish(Mockito.any());
        Mockito.verify(metrics).incrementCreated();
    }
}