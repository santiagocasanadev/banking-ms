package com.banking_ms.application.service;

import com.banking_ms.application.port.in.GetAccountBalanceUseCase;
import com.banking_ms.application.port.out.AccountRepositoryPort;
import com.banking_ms.domain.valueobject.AccountId;
import com.banking_ms.domain.valueobject.Money;
import org.springframework.stereotype.Service;

@Service
public class GetAccountBalanceService implements GetAccountBalanceUseCase {

    private final AccountRepositoryPort repository;

    public GetAccountBalanceService(AccountRepositoryPort accountRepositoryPort) {
        this.repository = accountRepositoryPort;
    }

    @Override
    public Money getBalance(AccountId accountId) {
        return repository.findBy(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found"))
                .balance();
    }

}
