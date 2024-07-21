package com.digital.bank.domain.account;

import java.math.BigDecimal;
import java.util.UUID;

public record AccountDtoOutput(

        UUID id,

        String agency,

        String number,

        BigDecimal balance,

        BigDecimal limit,

        BigDecimal availableLimit

) {
    public AccountDtoOutput(Account account) {
        this(
                account.getId(),
                account.getAgency(),
                account.getNumber(),
                account.getBalance(),
                account.getLimit(),
                account.getAvailableLimit()
        );
    }
}
