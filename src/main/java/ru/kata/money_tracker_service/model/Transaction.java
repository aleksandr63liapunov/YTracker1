package ru.kata.money_tracker_service.model;

import javax.persistence.*;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode()
@Table
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private Long id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "expense_wallet")
    private Wallet expenseWallet;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "income_wallet")
    private Wallet incomeWallet;

    @Enumerated
    private TypeOfTransation type;
    @Column(name = "amount_of_currency")
    private Double amountOfCurrency;
}
