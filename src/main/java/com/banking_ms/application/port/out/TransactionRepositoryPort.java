package com.banking_ms.application.port.out;

import com.banking_ms.domain.model.Transaction;
import com.banking_ms.infrastructure.adapter.out.persistence.entity.AccountEntity;

public interface TransactionRepositoryPort {

    Transaction save(Transaction transaction, AccountEntity accountEntity);

}