package com.digital.bank.controller;

import com.digital.bank.domain.account.AccountDtoInput;
import com.digital.bank.domain.account.AccountDtoOutput;
import com.digital.bank.domain.account.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("customer/{customer_id}/account")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping
    @Operation(summary = "Register customer account", description = "Only managers and administrator can register an account")
    @Transactional
    public ResponseEntity<URI> register(@PathVariable("customer_id") String customerId,
                                        @RequestBody AccountDtoInput accountInput) {
        AccountDtoOutput account = service.register(customerId, accountInput);
        return ResponseEntity.created(URI.create("/customer/" + customerId )).build();
    }
}
