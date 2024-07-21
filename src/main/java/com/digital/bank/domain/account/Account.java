package com.digital.bank.domain.account;

import com.digital.bank.domain.customer.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 5, unique = true, nullable = false)
    private String agency;

    @Column(length = 8, unique = true, nullable = false)
    private String number;

    @Column(precision = 13, scale = 2)
    private BigDecimal balance;

    @Column(name = "total_limit", precision = 13, scale = 2)
    private BigDecimal limit;

    @Column(name = "available_limit", precision = 13, scale = 2)
    private BigDecimal availableLimit;

    @OneToOne(mappedBy = "account")
    private Customer customer;
}
