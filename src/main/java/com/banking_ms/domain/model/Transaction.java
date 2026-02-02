package com.banking_ms.domain.model;

import com.banking_ms.domain.valueobject.Money;
import com.banking_ms.domain.valueobject.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Transaction {

    private final UUID id;
    private final Money amount;
    private final TransactionType type;
    private final LocalDateTime occurredAt;

    public Transaction(Money amount, TransactionType type) {
        this.id = UUID.randomUUID();
        this.amount = amount;
        this.type = type;
        this.occurredAt = LocalDateTime.now();
    }

    public static Transaction credit(Money amount) {
        return new Transaction(amount, TransactionType.CREDIT);
    }

    public static Transaction debit(Money amount) {
        return new Transaction(amount, TransactionType.DEBIT);
    }

    public UUID id() {
        return id;
    }

    public Money amount() {
        return amount;
    }

    public TransactionType type() {
        return type;
    }

    public LocalDateTime occurredAt() {
        return occurredAt;
    }

}
