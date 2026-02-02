package com.banking_ms.domain.model;

import com.banking_ms.domain.exception.InvalidAmountException;
import com.banking_ms.domain.valueobject.Money;
import com.banking_ms.domain.valueobject.TransactionType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TransactionTest {

    @Test
    void shouldRejectNegativeAmount() {
        assertThrows(InvalidAmountException.class, () ->
                new Transaction(new Money(BigDecimal.valueOf(-10), Currency.getInstance("USD")), TransactionType.CREDIT));
    }
}