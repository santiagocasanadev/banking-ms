package com.banking_ms.application.service;

import com.banking_ms.application.dto.OpenAccountCommand;
import com.banking_ms.application.port.in.OpenAccountUseCase;
import com.banking_ms.domain.model.Account;
import com.banking_ms.application.port.out.AccountRepositoryPort;
import com.banking_ms.domain.valueobject.AccountId;
import com.banking_ms.domain.valueobject.Money;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OpenAccountService implements OpenAccountUseCase {

    private final AccountRepositoryPort repository;

    public OpenAccountService(AccountRepositoryPort accountRepositoryPort) {
        this.repository = accountRepositoryPort;
    }

    @Override
    public AccountId openAccount(OpenAccountCommand command) {
        AccountId accountId = new AccountId(UUID.randomUUID());
        Money initialBalance = new Money(command.initialAmount(),
                command.currency());
        Account account = Account.open(accountId, initialBalance);

        repository.save(account);
        return accountId;
    }

}
