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
@EqualsAndHashCode(exclude = {"id"})
@Table
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private Long id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "expense_wallet_id")
    private Long expenseWallet;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "income_wallet_id")
    private Long incomeWallet;

    @Enumerated
    private TypeOfTransation type;
    @Column(name = "amount_of_currency")
    private Double amountOfCurrency;
}
