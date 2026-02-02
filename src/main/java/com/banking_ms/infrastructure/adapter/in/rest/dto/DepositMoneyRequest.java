package com.banking_ms.infrastructure.adapter.in.rest.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.UUID;

public record DepositMoneyRequest(
        @NotNull UUID accountId,
        @NotNull @Positive BigDecimal amount,
        @NotNull Currency currency
) {}
