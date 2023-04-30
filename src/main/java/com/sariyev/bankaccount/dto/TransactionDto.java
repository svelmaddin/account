package com.sariyev.bankaccount.dto;

import com.sariyev.bankaccount.model.Transaction;
import com.sariyev.bankaccount.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionDto(
        String id,
        TransactionType transactionType ,
        BigDecimal amount,
        LocalDateTime transactionDate
) {
}
