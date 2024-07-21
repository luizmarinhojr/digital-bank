package com.digital.bank.domain.customer;

import com.digital.bank.domain.address.AddressDtoInput;
import com.digital.bank.domain.user.UserDtoInput;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CustomerDtoInput(

        @NotNull
        UserDtoInput user,

        @NotEmpty
        String name,

        @JsonProperty("last_name")
        @NotEmpty
        String lastName,

        @NotEmpty
        String cellphone,

        @NotNull
        AddressDtoInput address
) {
}
