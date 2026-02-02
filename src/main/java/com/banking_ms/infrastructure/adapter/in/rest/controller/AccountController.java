package com.banking_ms.infrastructure.adapter.in.rest.controller;

import com.banking_ms.application.port.in.DepositMoneyUseCase;
import com.banking_ms.application.port.in.GetAccountBalanceUseCase;
import com.banking_ms.application.port.in.OpenAccountUseCase;
import com.banking_ms.application.port.in.WithdrawMoneyUseCase;
import com.banking_ms.domain.valueobject.AccountId;
import com.banking_ms.infrastructure.adapter.in.rest.dto.AccountBalanceResponse;
import com.banking_ms.infrastructure.adapter.in.rest.dto.DepositMoneyRequest;
import com.banking_ms.infrastructure.adapter.in.rest.dto.OpenAccountRequest;
import com.banking_ms.infrastructure.adapter.in.rest.dto.WithdrawMoneyRequest;
import com.banking_ms.infrastructure.adapter.in.rest.mapper.AccountRestMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final OpenAccountUseCase openAccountUseCase;
    private final DepositMoneyUseCase depositMoneyUseCase;
    private final WithdrawMoneyUseCase withdrawMoneyUseCase;
    private final GetAccountBalanceUseCase getAccountBalanceUseCase;
    private final AccountRestMapper mapper;

    public AccountController(OpenAccountUseCase openAccountUseCase,
                             DepositMoneyUseCase depositMoneyUseCase,
                             WithdrawMoneyUseCase withdrawMoneyUseCase,
                             GetAccountBalanceUseCase getAccountBalanceUseCase,
                             AccountRestMapper mapper
                            ) {
        this.openAccountUseCase = openAccountUseCase;
        this.depositMoneyUseCase = depositMoneyUseCase;
        this.withdrawMoneyUseCase = withdrawMoneyUseCase;
        this.getAccountBalanceUseCase = getAccountBalanceUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UUID open(@RequestBody @Valid OpenAccountRequest request){
        return openAccountUseCase.openAccount(mapper.toCommand(request)).value();
    }

    @PostMapping("/deposit")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deposit(@RequestBody @Valid DepositMoneyRequest request){
        depositMoneyUseCase.deposit(mapper.toCommand(request));
    }

    @PostMapping("withdraw")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void withdraw(@RequestBody @Valid WithdrawMoneyRequest request){
        withdrawMoneyUseCase.withdraw(mapper.toCommand(request));
    }

    @GetMapping("/{id}/balance")
    public AccountBalanceResponse balance(@PathVariable UUID id){
        return mapper.toResponse(getAccountBalanceUseCase.getBalance(new AccountId(id)));
    }
}
