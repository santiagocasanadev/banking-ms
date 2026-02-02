package com.banking_ms.infrastructure.adapter.out.persistence.mapper;

import com.banking_ms.domain.model.Transaction;
import com.banking_ms.infrastructure.adapter.out.persistence.entity.TransactionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface TransactionPersistenceMapper {

    TransactionEntity toEntity(Transaction transaction);

    Transaction toDomain(TransactionEntity entity);

}
