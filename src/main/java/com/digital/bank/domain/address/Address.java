package com.digital.bank.domain.address;

import com.digital.bank.domain.customer.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "addresses")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 10, nullable = false)
    private String cep;

    @Column(length = 35, nullable = false)
    private String street;

    @Column(length = 8, nullable = false)
    private String number;

    @Column(length = 30)
    private String complement;

    @Column(length = 35, nullable = false)
    private String neighborhood;

    @Column(length = 35, nullable = false)
    private String city;

    @Column(length = 35, nullable = false)
    private String state;

    @Column(length = 35, nullable = false)
    private String country;

    @OneToOne(mappedBy = "address")
    private Customer customer;
}
