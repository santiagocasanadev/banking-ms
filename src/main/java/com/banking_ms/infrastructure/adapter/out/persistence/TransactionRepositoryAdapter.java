package com.banking_ms.infrastructure.adapter.out.persistence;

import com.banking_ms.domain.model.Transaction;
import com.banking_ms.application.port.out.TransactionRepositoryPort;
import com.banking_ms.infrastructure.adapter.out.persistence.entity.AccountEntity;
import com.banking_ms.infrastructure.adapter.out.persistence.entity.TransactionEntity;
import com.banking_ms.infrastructure.adapter.out.persistence.mapper.TransactionPersistenceMapper;
import com.banking_ms.infrastructure.adapter.out.persistence.repository.JpaTransactionRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class TransactionRepositoryAdapter implements TransactionRepositoryPort {

    private final JpaTransactionRepository jpaRepository;
    private final TransactionPersistenceMapper mapper;

    public TransactionRepositoryAdapter(JpaTransactionRepository jpaRepository, TransactionPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Transaction save(Transaction transaction, AccountEntity accountEntity) {
        TransactionEntity entity = mapper.toEntity(transaction);
        entity.setAccount(accountEntity);
        return mapper.toDomain(jpaRepository.save(entity));
    }

}
