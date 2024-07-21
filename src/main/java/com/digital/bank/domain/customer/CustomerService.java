package com.digital.bank.domain.customer;

import com.digital.bank.domain.address.Address;
import com.digital.bank.domain.address.AddressRepository;
import com.digital.bank.domain.user.User;
import com.digital.bank.domain.user.UserRepository;
import com.digital.bank.infra.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    public CustomerDtoOutput describe(String id) {
        try {
            return customerRepository.findById(UUID.fromString(id))
                    .map(CustomerDtoOutput::new)
                    .orElseThrow(() -> new NotFoundException("Customer id not found"));
        } catch(IllegalArgumentException ex) {
            throw new NotFoundException(ex.getMessage());
        }
    }

    public CustomerDtoOutput register(CustomerDtoInput customerInput) {
        var user = userRepository.save(new User(customerInput.user()));
        var address = addressRepository.save(new Address(customerInput.address()));
        var customer = customerRepository.save(new Customer(customerInput, user, address));
        return new CustomerDtoOutput(customer);
    }
}