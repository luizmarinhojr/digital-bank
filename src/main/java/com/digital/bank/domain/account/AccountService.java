package com.digital.bank.domain.account;

import com.digital.bank.domain.card.Card;
import com.digital.bank.domain.card.CardRepository;
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

    @Autowired
    private CardRepository cardRepository;

    public AccountDtoOutput register(String customerId, AccountDtoInput accountInput) {
        var customer = customerRepository.findById(convertFromString(customerId)).orElseThrow(() -> new NotFoundException("Customer id not found"));
        var account = accountRepository.save(new Account(accountInput));
        customer.setAccount(account);
        var card = cardRepository.save(new Card(customer));
        customer.addCard(card);
        customerRepository.flush();
        return new AccountDtoOutput(account);
    }

    private UUID convertFromString(String id) {
        try {
            return UUID.fromString(id);
        } catch(IllegalArgumentException ex) {
            throw new NotFoundException("Customer id not found");
        }
    }
}
