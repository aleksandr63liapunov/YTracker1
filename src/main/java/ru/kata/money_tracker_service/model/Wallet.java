package ru.kata.money_tracker_service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@EqualsAndHashCode()

public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    public Wallet(String title, CurrencyEnum currency, double totalAmount) {
        this.title = title;
        this.currency = currency;
        this.totalAmount = totalAmount;
    }

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Account.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @JsonBackReference
    private Account account;

    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency;

    private double totalAmount;

    private long groupWalletsId;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wallet")
    @JsonBackReference
    private Set<Transaction> transaction;

}