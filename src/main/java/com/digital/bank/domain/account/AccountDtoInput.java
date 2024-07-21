package com.digital.bank.domain.account;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

public record AccountDtoInput(

        @NotEmpty
        @Length(max = 5)
        String agency,

        @NotEmpty
        @Length(max = 8)
        String number,

        BigDecimal limit

) {
}
