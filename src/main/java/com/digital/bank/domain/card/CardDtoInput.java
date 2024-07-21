package com.digital.bank.domain.card;

import java.time.LocalDate;

public record CardDtoInput(

        String number,

        String cvv,

        LocalDate dateExpiration
) {
}
