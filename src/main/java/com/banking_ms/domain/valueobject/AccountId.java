package com.banking_ms.domain.valueobject;

import java.util.Objects;
import java.util.UUID;

public record AccountId(UUID value) {
    public AccountId{
        Objects.requireNonNull(value, "AccountId cannot be null");
    }
}
