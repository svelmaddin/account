package com.sariyev.bankaccount.mapper;

import com.sariyev.bankaccount.dto.TransactionDto;
import com.sariyev.bankaccount.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {
    public TransactionDto convert(Transaction from) {
        return new TransactionDto(from.getId(),
                from.getTransactionType(),
                from.getAmount(),
                from.getTransactionDate()
        );
    }
}
