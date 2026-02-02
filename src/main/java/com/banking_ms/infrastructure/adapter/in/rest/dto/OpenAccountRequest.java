package com.banking_ms.infrastructure.adapter.in.rest.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.Currency;

public record OpenAccountRequest(
        @NotNull @Positive BigDecimal initialAmount,
        @NotNull Currency currency
) {}
