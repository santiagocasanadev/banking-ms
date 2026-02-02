package com.banking_ms.application.service;

import com.banking_ms.application.dto.DepositMoneyCommand;
import com.banking_ms.application.port.in.DepositMoneyUseCase;
import com.banking_ms.domain.model.Account;
import com.banking_ms.application.port.out.AccountRepositoryPort;
import com.banking_ms.domain.valueobject.Money;
import org.springframework.stereotype.Service;

@Service
public class DepositMoneyService implements DepositMoneyUseCase {

    private final AccountRepositoryPort repository;

    public DepositMoneyService(AccountRepositoryPort accountRepositoryPort) {
        this.repository = accountRepositoryPort;
    }

    @Override
    public void deposit(DepositMoneyCommand command) {
        Account account = repository.findBy(command.accountId())
                .orElseThrow(() -> new IllegalArgumentException("Account not found"));

        Money money = new Money(command.amount(), command.currency());
        account.deposit(money);
        repository.save(account);
    }

}
