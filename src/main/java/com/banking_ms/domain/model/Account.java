package com.banking_ms.domain.model;

import com.banking_ms.domain.valueobject.AccountId;
import com.banking_ms.domain.valueobject.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
public class Account {

    private final AccountId id;
    private Money balance;
    private final List<Transaction> transactions = new ArrayList<>();

//    private Account(AccountId id, Money initialBalance) {
//        this.id = id;
//        this.balance = initialBalance;
//    }

    public static Account open(AccountId id, Money initialBalance) {
        return new Account(id, initialBalance);
    }

    public void deposit(Money amount) {
        balance = balance.add(amount);
        transactions.add(Transaction.credit(amount));
    }

    public void withdraw(Money amount) {
        balance = balance.substract(amount);
        transactions.add(Transaction.debit(amount));
    }

    public Money balance() {
        return balance;
    }

    public AccountId id() {
        return id;
    }

    public List<Transaction> transactions() {
        return Collections.unmodifiableList(transactions);
    }

}
