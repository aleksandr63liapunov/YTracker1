package ru.kata.money_tracker_service.model;

import lombok.Data;

import javax.persistence.*;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExpenseWalletId() {
        return expenseWalletId;
    }

    public void setExpenseWalletId(Long expenseWalletId) {
        this.expenseWalletId = expenseWalletId;
    }

    public Long getIncomeWalletId() {
        return incomeWalletId;
    }

    public void setIncomeWalletId(Long incomeWalletId) {
        this.incomeWalletId = incomeWalletId;
    }

    public TypeOfTransation getType() {
        return type;
    }

    public void setType(TypeOfTransation type) {
        this.type = type;
    }

    public Double getAmountOfCurrency() {
        return amountOfCurrency;
    }

    public void setAmountOfCurrency(Double amountOfCurrency) {
        this.amountOfCurrency = amountOfCurrency;
    }

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
