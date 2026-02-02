package com.banking_ms.infrastructure.adapter.out.persistence;

import com.banking_ms.domain.model.Account;
import com.banking_ms.application.port.out.AccountRepositoryPort;
import com.banking_ms.domain.valueobject.AccountId;
import com.banking_ms.infrastructure.adapter.out.persistence.entity.AccountEntity;
import com.banking_ms.infrastructure.adapter.out.persistence.mapper.AccountPersistenceMapper;
import com.banking_ms.infrastructure.adapter.out.persistence.repository.JpaAccountRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AccountRepositoryAdapter implements AccountRepositoryPort {

    private final JpaAccountRepository jpaRepository;
    private final AccountPersistenceMapper mapper;

    public AccountRepositoryAdapter(JpaAccountRepository jpaRepository, AccountPersistenceMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Account> findBy(AccountId id) {
        return jpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public Account save(Account account) {
        AccountEntity entity = mapper.toEntity(account);
        AccountEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }
}
