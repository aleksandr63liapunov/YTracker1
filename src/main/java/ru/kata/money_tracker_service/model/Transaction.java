package ru.kata.money_tracker_service.model;

import javax.persistence.*;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;

@Entity
@Data
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "expense_wallet_id")
    private Long expenseWalletId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "income_wallet_id")
    private Long incomeWalletId;
    @Enumerated
    private TypeOfTransation type;
    @Column(name = "amount_of_currency")
    private Double amountOfCurrency;

    public Transaction() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(expenseWalletId, that.expenseWalletId) && Objects.equals(incomeWalletId, that.incomeWalletId) && Objects.equals(amountOfCurrency, that.amountOfCurrency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expenseWalletId, incomeWalletId, amountOfCurrency);
    }
}
