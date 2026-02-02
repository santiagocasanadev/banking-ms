package com.banking_ms.domain.valueobject;

import com.banking_ms.domain.exception.InsufficientFundsException;
import com.banking_ms.domain.exception.InvalidAmountException;

import java.math.BigDecimal;
import java.util.Currency;

public final class Money {

    private final BigDecimal amount;
    private final Currency currency;

    public Money(BigDecimal amount, Currency currency) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidAmountException();
        }
        this.amount = amount;
        this.currency = currency;
    }

    public BigDecimal amount() {
        return amount;
    }

    public Currency currency() {
        return currency;
    }

    public Money add(Money other) {
        validateCurrency(other);
        return new Money(this.amount.add(other.amount), currency);
    }

    public Money substract(Money other) {
        validateCurrency(other);
        if (this.amount.compareTo(other.amount) < 0) {
            throw new InsufficientFundsException();
        }
        return new Money(this.amount.subtract(other.amount), currency);
    }

    private void validateCurrency(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Currency mismtach");
        }
    }

}
