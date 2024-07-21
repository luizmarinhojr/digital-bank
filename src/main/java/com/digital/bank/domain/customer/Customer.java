package com.digital.bank.domain.customer;

import com.digital.bank.domain.address.Address;
import com.digital.bank.domain.account.Account;
import com.digital.bank.domain.card.Card;
import com.digital.bank.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "customers")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;

    @Column(length = 35, nullable = false)
    private String name;

    @Column(name = "last_name", length = 40, nullable = false)
    private String lastName;

    @Column(length = 25, nullable = false)
    private String cellphone;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @Setter
    private Address address;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @Setter
    private Account account;

    @OneToMany(mappedBy = "customer")
    @Setter
    private Set<Card> card = new HashSet<>();

    /*
    Constructor to add a Customer with User and Address.
     */
    public Customer(CustomerDtoInput customerInput, User user, Address address) {
        this.user = user;
        this.name = customerInput.name();
        this.lastName = customerInput.lastName();
        this.cellphone = customerInput.cellphone();
        this.address = address;
    }


    public void addCard(Card card) {
        this.card.add(card);
    }
}
