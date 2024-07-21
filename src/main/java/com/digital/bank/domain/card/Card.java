package com.digital.bank.domain.card;

import com.digital.bank.domain.customer.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Random;
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

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    /*
    Create a random Card
     */
    public Card(Customer customer) {
        var random = new Random();
        this.number = "";
        for (int i = 0; i < 4; i++) {
            this.number += String.valueOf(random.nextInt(1000,9999));
        }
        this.cvv = String.valueOf(random.nextInt(100,999));
        this.dateExpiration = LocalDate.now().plusYears(3);
        this.customer = customer;
    }
}
