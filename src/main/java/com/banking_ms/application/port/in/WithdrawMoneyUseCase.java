package com.banking_ms.application.port.in;

import com.banking_ms.application.dto.WithdrawMoneyCommand;

public interface WithdrawMoneyUseCase {

    void withdraw(WithdrawMoneyCommand command);

}
