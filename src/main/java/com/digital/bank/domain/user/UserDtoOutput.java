package com.digital.bank.domain.user;

import java.util.UUID;

public record UserDtoOutput(

        UUID id,

        String cpf,

        String email
) {
    public UserDtoOutput(User user) {
        this(
                user.getId(),
                user.getCpf(),
                user.getEmail()
        );
    }
}
