package com.banking_ms.application.port.in;

import com.banking_ms.domain.valueobject.AccountId;
import com.banking_ms.domain.valueobject.Money;

public interface GetAccountBalanceUseCase {

    Money getBalance(AccountId accountId);

}
