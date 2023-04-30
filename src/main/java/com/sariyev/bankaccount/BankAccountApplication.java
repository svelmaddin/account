package com.sariyev.bankaccount;

import com.sariyev.bankaccount.model.Customer;
import com.sariyev.bankaccount.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class BankAccountApplication implements CommandLineRunner {

	public BankAccountApplication(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	private final CustomerRepository customerRepository;
	public static void main(String[] args) {
		SpringApplication.run(BankAccountApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer = customerRepository.save(new Customer("elmaddin" , "sariyev" ,new HashSet<>()));
		System.out.println(customer);
	}
}
