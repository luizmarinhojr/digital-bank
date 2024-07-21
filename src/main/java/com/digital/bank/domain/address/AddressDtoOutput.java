package com.digital.bank.domain.address;

import java.util.UUID;

public record AddressDtoOutput(

        UUID id,

        String cep,

        String street,

        String number,

        String complement,

        String neighborhood,

        String city,

        String state,

        String country

) {
    public AddressDtoOutput(Address address) {
        this(
                address.getId(),
                address.getCep(),
                address.getStreet(),
                address.getNumber(),
                address.getComplement(),
                address.getNeighborhood(),
                address.getCity(),
                address.getState(),
                address.getCountry()
        );
    }
}
