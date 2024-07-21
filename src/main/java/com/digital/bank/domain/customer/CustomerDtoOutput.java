package com.digital.bank.domain.customer;

import com.digital.bank.domain.account.AccountDtoOutput;
import com.digital.bank.domain.address.AddressDtoOutput;
import com.digital.bank.domain.card.CardDtoOutput;
import com.digital.bank.domain.user.UserDtoOutput;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public record CustomerDtoOutput(

        UUID id,

        UserDtoOutput user,

        String name,

        @JsonAlias("last_name")
        String lastName,

        String cellphone,

        AddressDtoOutput address,

        AccountDtoOutput account,

        Set<CardDtoOutput> card
) {
    public CustomerDtoOutput(Customer customer) {
        this(
                customer.getId(),
                new UserDtoOutput(customer.getUser()),
                customer.getName(),
                customer.getLastName(),
                customer.getCellphone(),
                customer.getAddress() == null ? null : new AddressDtoOutput(customer.getAddress()),
                customer.getAccount() == null ? null : new AccountDtoOutput(customer.getAccount()),
                customer.getCard() == null ? null : customer.getCard().stream().map(CardDtoOutput::new).collect(Collectors.toSet())
        );
    }
}
