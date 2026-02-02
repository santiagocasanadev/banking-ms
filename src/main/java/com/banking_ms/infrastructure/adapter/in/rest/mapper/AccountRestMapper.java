package com.banking_ms.infrastructure.adapter.in.rest.mapper;

import com.banking_ms.application.dto.DepositMoneyCommand;
import com.banking_ms.application.dto.OpenAccountCommand;
import com.banking_ms.application.dto.WithdrawMoneyCommand;
import com.banking_ms.domain.valueobject.Money;
import com.banking_ms.infrastructure.adapter.in.rest.dto.AccountBalanceResponse;
import com.banking_ms.infrastructure.adapter.in.rest.dto.DepositMoneyRequest;
import com.banking_ms.infrastructure.adapter.in.rest.dto.OpenAccountRequest;
import com.banking_ms.infrastructure.adapter.in.rest.dto.WithdrawMoneyRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountRestMapper {
    OpenAccountCommand toCommand(OpenAccountRequest request);

    @Mapping(target = "accountId", expression = "java(new AccountId(request.accountId()))")
    DepositMoneyCommand toCommand(DepositMoneyRequest request);

    @Mapping(target = "accountId", expression = "java(new AccountId(request.accountId()))")
    WithdrawMoneyCommand toCommand(WithdrawMoneyRequest request);

    default AccountBalanceResponse toResponse(Money money){
        return new AccountBalanceResponse(money.amount(),money.currency());
    }

}
