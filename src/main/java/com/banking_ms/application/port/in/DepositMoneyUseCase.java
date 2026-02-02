package com.banking_ms.application.port.in;

import com.banking_ms.application.dto.DepositMoneyCommand;

public interface DepositMoneyUseCase {

    void deposit(DepositMoneyCommand command);

}
