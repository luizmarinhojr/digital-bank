package com.digital.bank.domain.card;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.UUID;

public record CardDtoOutput(

        UUID id,

        String number,

        String cvv,

        @JsonProperty("date_expiration")
        LocalDate dateExpiration

) {
    public CardDtoOutput(Card card) {
        this(
                card.getId(),
                card.getNumber(),
                card.getCvv(),
                card.getDateExpiration()
        );
    }
}
