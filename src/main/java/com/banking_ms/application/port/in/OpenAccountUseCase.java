package com.banking_ms.application.port.in;

import com.banking_ms.application.dto.OpenAccountCommand;
import com.banking_ms.domain.valueobject.AccountId;

public interface OpenAccountUseCase {

    AccountId openAccount(OpenAccountCommand command);

}
