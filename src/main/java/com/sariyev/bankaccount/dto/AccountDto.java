package com.sariyev.bankaccount.dto;

import com.sariyev.bankaccount.model.Customer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public record AccountDto(
        String id,
        BigDecimal balance,
        LocalDateTime creationDate,
        AccountCustomerDto customer,
        Set<TransactionDto> transactions
) {
}
