package com.banking_ms.application.port.out;

import com.banking_ms.domain.model.Account;
import com.banking_ms.domain.valueobject.AccountId;

import java.util.Optional;

public interface AccountRepositoryPort {

    Optional<Account> findBy(AccountId id);

    Account save(Account account);

}
