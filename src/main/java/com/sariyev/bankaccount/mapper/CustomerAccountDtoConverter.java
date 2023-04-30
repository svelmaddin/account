package com.sariyev.bankaccount.mapper;

import com.sariyev.bankaccount.dto.CustomerAccountDto;
import com.sariyev.bankaccount.model.Account;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class CustomerAccountDtoConverter {
    private final TransactionDtoConverter converter;

    public CustomerAccountDtoConverter(TransactionDtoConverter converter) {
        this.converter = converter;
    }

    public CustomerAccountDto convert(Account from) {
        return new CustomerAccountDto(
                Objects.requireNonNull(from.getId()),
                from.getBalance(),
                from.getTransactions().stream().map(converter::convert).collect(Collectors.toSet()),
                from.getCreationDate());
    }
}
