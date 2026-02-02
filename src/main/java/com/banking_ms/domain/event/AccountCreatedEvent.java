package com.banking_ms.domain.event;

import com.banking_ms.domain.valueobject.AccountId;
import com.banking_ms.domain.valueobject.Money;

public record AccountCreatedEvent(
        AccountId accountId,
        Money initialBalance
) {}
