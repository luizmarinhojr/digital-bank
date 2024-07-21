package com.digital.bank.domain.card;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "cards")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(length = 16, unique = true, nullable = false)
    private String number;

    @Column(length = 4, nullable = false)
    private String cvv;

    @Column(nullable = false)
    private LocalDate dateExpiration;
}
