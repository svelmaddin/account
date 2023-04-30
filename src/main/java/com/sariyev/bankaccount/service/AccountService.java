package com.sariyev.bankaccount.service;

import com.sariyev.bankaccount.dto.AccountDto;
import com.sariyev.bankaccount.dto.CreateAccountRequest;
import com.sariyev.bankaccount.mapper.AccountDtoConverter;
import com.sariyev.bankaccount.model.Account;
import com.sariyev.bankaccount.model.Customer;
import com.sariyev.bankaccount.model.Transaction;
import com.sariyev.bankaccount.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDtoConverter converter;

    public AccountService(AccountRepository accountRepository,
                          CustomerService customerService,
                          AccountDtoConverter converter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.converter = converter;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.findCustomerByID(createAccountRequest.getCustomerId());
        Account account = new Account(
                createAccountRequest.getInitialCredit(),
                LocalDateTime.now(),
                customer);
        if (createAccountRequest.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
            Transaction transaction = new Transaction(createAccountRequest.getInitialCredit(), account);
            account.getTransactions().add(transaction);
        }
        return converter.convert(accountRepository.save(account));
    }

}
