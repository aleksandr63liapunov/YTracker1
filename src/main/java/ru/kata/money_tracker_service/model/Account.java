package ru.kata.money_tracker_service.model;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Table(name = "account_table")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private long id;
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    @Column(name = "is_main_user")
    @NotEmpty
    private boolean isMainUser;
//    @Column(name = "main_currency")
//    @NotEmpty
    @Enumerated(EnumType.STRING)
    private CurrencyEnum mainCurrency;
    @OneToOne(mappedBy = "account")
    private Wallet wallet;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (userId != account.userId) return false;
        if (isMainUser != account.isMainUser) return false;
        return mainCurrency == account.mainCurrency;
    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (isMainUser ? 1 : 0);
        result = 31 * result + (mainCurrency != null ? mainCurrency.hashCode() : 0);
        return result;
    }
}
