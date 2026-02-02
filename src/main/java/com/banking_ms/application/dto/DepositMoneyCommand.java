package com.banking_ms.application.dto;

import com.banking_ms.domain.valueobject.AccountId;

import java.math.BigDecimal;
import java.util.Currency;

public record DepositMoneyCommand(
        AccountId accountId,
        BigDecimal amount,
        Currency currency
) {}
