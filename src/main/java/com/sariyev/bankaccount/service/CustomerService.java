package com.sariyev.bankaccount.service;

import com.sariyev.bankaccount.exception.CustomerNotFoundException;
import com.sariyev.bankaccount.model.Customer;
import com.sariyev.bankaccount.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    protected Customer findCustomerByID(String id) {
        return customerRepository.findById(id)
                .orElseThrow(
                        () -> new CustomerNotFoundException("Customer could not find by id: " + id));
    }


}
