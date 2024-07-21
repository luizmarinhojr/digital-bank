package com.digital.bank.domain.customer;

import com.digital.bank.domain.account.AccountDtoOutput;
import com.digital.bank.domain.address.AddressDtoOutput;
import com.digital.bank.domain.user.UserDtoOutput;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.UUID;

public record CustomerDtoOutput(

        UUID id,

        UserDtoOutput user,

        String name,

        @JsonAlias("last_name")
        String lastName,

        String cellphone,

        AddressDtoOutput address,

        AccountDtoOutput account
) {
    public CustomerDtoOutput(Customer customer) {
        this(
                customer.getId(),
                new UserDtoOutput(customer.getUser()),
                customer.getName(),
                customer.getLastName(),
                customer.getCellphone(),
                customer.getAddress() == null ? null : new AddressDtoOutput(customer.getAddress()),
                customer.getAccount() == null ? null : new AccountDtoOutput(customer.getAccount())
        );
    }
}
