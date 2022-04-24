package ru.kata.money_tracker_service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode()

public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Account.class)
    @JoinColumn(name = "account_id", referencedColumnName = "id")

    @JsonManagedReference
    private Account account;

    @Enumerated(EnumType.STRING)
    private CurrencyEnum currency;

    private double totalAmount;

    private long groupWalletsId;
}