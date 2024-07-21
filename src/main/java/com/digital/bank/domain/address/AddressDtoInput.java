package com.digital.bank.domain.address;

import jakarta.validation.constraints.NotEmpty;

public record AddressDtoInput(

        @NotEmpty
        String cep,

        @NotEmpty
        String street,

        @NotEmpty
        String number,

        String complement,

        @NotEmpty
        String neighborhood,

        @NotEmpty
        String city,

        @NotEmpty
        String state,

        @NotEmpty
        String country

) {
}
