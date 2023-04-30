package com.sariyev.bankaccount.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public record CustomerAccountDto(
        String id,
        Set<TransactionDto> transactions,
        BigDecimal balance,
        LocalDateTime creationDate
) {
}
