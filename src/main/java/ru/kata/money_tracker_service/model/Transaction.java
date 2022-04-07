package ru.kata.money_tracker_service.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode (exclude = {"id"})

@Table
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long id;

    @JoinColumn(name = "expense_wallet_id")
    private Long expenseWalletId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "expense_wallet", referencedColumnName = "id")
    private ExpenseWallet expenseWallet;

    @JoinColumn(name = "income_wallet_id")
    private Long incomeWalletId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "income_wallet", referencedColumnName = "id")
    private IncomeWallet incomeWallet;

    @Enumerated
    private TypeOfTransation type;
    @Column(name = "amount_of_currency")
    private Double amountOfCurrency;



    public Transaction(Long expenseWalletId, Long incomeWalletId, TypeOfTransation type, Double amountOfCurrency) {
        this.expenseWalletId = expenseWalletId;
        this.incomeWalletId = incomeWalletId;
        this.type = type;
        this.amountOfCurrency = amountOfCurrency;
    }
}
