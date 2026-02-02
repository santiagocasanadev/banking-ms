package com.banking_ms.application.dto;

import java.math.BigDecimal;
import java.util.Currency;

public record OpenAccountCommand(
        BigDecimal initialAmount,
        Currency currency
) {
}
