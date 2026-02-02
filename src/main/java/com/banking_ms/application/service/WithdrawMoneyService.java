package com.banking_ms.application.service;

import com.banking_ms.application.dto.WithdrawMoneyCommand;
import com.banking_ms.application.port.in.WithdrawMoneyUseCase;
import com.banking_ms.domain.model.Account;
import com.banking_ms.application.port.out.AccountRepositoryPort;
import com.banking_ms.domain.valueobject.Money;
import org.springframework.stereotype.Service;

@Service
public class WithdrawMoneyService implements WithdrawMoneyUseCase {

    private final AccountRepositoryPort repository;

    public WithdrawMoneyService(AccountRepositoryPort accountRepositoryPort) {
        this.repository = accountRepositoryPort;
    }

    @Override
    public void withdraw(WithdrawMoneyCommand command) {
        Account account = repository.findBy(command.accountId())
                .orElseThrow(() -> new IllegalArgumentException("Account not fount"));

        Money money = new Money(command.amount(), command.currency());
        account.withdraw(money);
        repository.save(account);
    }

}
