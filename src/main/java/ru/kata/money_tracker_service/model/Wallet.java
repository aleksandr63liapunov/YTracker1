package ru.kata.money_tracker_service.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"id", "accountId"})
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private long id;

    private String title;

    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private long accountId; // (ont-to-one);

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Account.class)
    @JoinColumn(name = "account", referencedColumnName = "id")
    private Account account;

    private CurrencyEnum currency;

    private double totalAmount;

    private long GroupWalletsId;

    public Wallet(String title, Account account, CurrencyEnum currency, double totalAmount, long groupWalletsId) {
        this.title = title;
        this.account = account;
        this.currency = currency;
        this.totalAmount = totalAmount;
        GroupWalletsId = groupWalletsId;
    }
}
