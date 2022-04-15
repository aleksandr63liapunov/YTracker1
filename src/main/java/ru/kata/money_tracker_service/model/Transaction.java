package ru.kata.money_tracker_service.model;

import javax.persistence.*;

import lombok.*;

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

    @OneToOne
    @JoinColumn (name = "expense_wallet")
    private Wallet expenseWallet;

    @OneToOne
    @JoinColumn(name = "income_wallet")
    private Wallet incomeWallet;

    @Enumerated(EnumType.STRING)
    private TypeOfTransation type;

    @Column(name = "amount_of_currency")
    private Double amountOfCurrency;
}
