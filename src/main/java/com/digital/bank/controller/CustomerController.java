package com.digital.bank.controller;

import com.digital.bank.domain.customer.CustomerDtoInput;
import com.digital.bank.domain.customer.CustomerDtoOutput;
import com.digital.bank.domain.customer.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    @Operation(
            summary = "Register a new Customer and User on System",
            description = "The user and the address are required to register a new Customer")
    @Transactional
    public ResponseEntity register(@RequestBody CustomerDtoInput customerInput) {
        CustomerDtoOutput customer = service.register(customerInput);
        return ResponseEntity.created(URI.create("/customer/" + customer.id())).build();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Describe Customer Data", description = "Like User, Address, name, Account...")
    public ResponseEntity<CustomerDtoOutput> describe(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.describe(id));
    }
}
