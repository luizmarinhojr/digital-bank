package com.digital.bank.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UserDtoInput(

        @NotEmpty
        String cpf,

        @Email
        @NotEmpty
        String email,

        @NotEmpty
        String password

) {
}
