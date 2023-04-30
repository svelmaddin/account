package com.sariyev.bankaccount.service;

import com.sariyev.bankaccount.dto.CustomerDto;
import com.sariyev.bankaccount.exception.CustomerNotFoundException;
import com.sariyev.bankaccount.mapper.CustomerDtoConverter;
import com.sariyev.bankaccount.model.Customer;
import com.sariyev.bankaccount.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    protected Customer findCustomerByID(String id) {
        return customerRepository.findById(id)
                .orElseThrow(
                        () -> new CustomerNotFoundException("Customer could not find by id: " + id));
    }


    public CustomerDto getCustomerById(String customerId) {
       return converter.convertToCustomerDto(findCustomerByID(customerId));
    }
}
