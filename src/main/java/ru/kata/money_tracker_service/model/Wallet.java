package ru.kata.money_tracker_service.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "wallet_table")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title")
    private String title;
    //@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private long accountId; // (ont-to-one);
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account", referencedColumnName = "account_id")
    private Account account;
    @Column(name = "currency")
    private CurrencyEnum currency;
    @Column(name = "total_amount")
    private double totalAmmount;
    @Column(name = "group_wallets_id")
    private long GroupWalletsId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wallet wallet = (Wallet) o;

        if (Double.compare(wallet.totalAmmount, totalAmmount) != 0) return false;
        if (title != null ? !title.equals(wallet.title) : wallet.title != null) return false;
        if (account != null ? !account.equals(wallet.account) : wallet.account != null) return false;
        return currency == wallet.currency;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = title != null ? title.hashCode() : 0;
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        temp = Double.doubleToLongBits(totalAmmount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
