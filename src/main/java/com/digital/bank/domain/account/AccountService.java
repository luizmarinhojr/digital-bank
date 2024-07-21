package com.digital.bank.domain.account;

import com.digital.bank.domain.customer.CustomerRepository;
import com.digital.bank.infra.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    public AccountDtoOutput register(String customerId, AccountDtoInput accountInput) {
        try {
            var customer = customerRepository.findById(UUID.fromString(customerId))
                    .orElseThrow(() -> new NotFoundException("Customer id not found"));
            var account = accountRepository.save(new Account(accountInput));
            customer.setAccount(account);
            customerRepository.flush();
            return new AccountDtoOutput(account);
        } catch(IllegalArgumentException ex) {
            throw new NotFoundException(ex.getMessage());
        }
    }
}
