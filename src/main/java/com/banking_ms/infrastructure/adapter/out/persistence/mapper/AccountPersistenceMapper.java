package com.banking_ms.infrastructure.adapter.out.persistence.mapper;

import com.banking_ms.domain.model.Account;
import com.banking_ms.domain.valueobject.AccountId;
import com.banking_ms.domain.valueobject.Money;
import com.banking_ms.infrastructure.adapter.out.persistence.entity.AccountEntity;
import com.banking_ms.infrastructure.adapter.out.persistence.entity.TransactionEntity;
import org.mapstruct.Mapper;

import java.util.Currency;

@Mapper(componentModel = "spring")
public interface AccountPersistenceMapper {

    default AccountEntity toEntity(Account account) {
        AccountEntity entity = new AccountEntity(
                account.id().value(),
                account.balance().amount(),
                account.balance().currency().getCurrencyCode()
        );

        account.transactions().forEach(tx -> {
            TransactionEntity txEntity = new TransactionEntity(
                    tx.amount().amount(),
                    tx.amount().currency().getCurrencyCode(),
                    tx.type().name(),
                    tx.occurredAt()
            );
            entity.addTransaction(txEntity);
        });

        return entity;
    }

    default Account toDomain(AccountEntity entity) {
        Money balance = new Money( entity.getBalance(),
                Currency.getInstance(entity.getCurrency()));

        Account account = Account.open(new AccountId(entity.getId()),
                balance);

        entity.getTransactions().forEach(tx -> {
            Money money = new Money(tx.getAmount(),
                    Currency.getInstance(tx.getCurrency()));
            if ("CREDIT".equals(tx.getType())) {
                account.deposit(money);
            } else {
                account.withdraw(money);
            }
        });

        return account;
    }
}
