package com.banking_ms.infrastructure.adapter.in.rest.dto;

import com.banking_ms.domain.model.Transaction;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

public record AccountBalanceResponse(
        @NotNull @Positive BigDecimal amount,
        @NotNull Currency currency
) {}
