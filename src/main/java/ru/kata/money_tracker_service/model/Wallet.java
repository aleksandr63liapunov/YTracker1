package ru.kata.money_tracker_service.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"id", "accountId", "groupWalletsId"})
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private long accountId;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Account.class)
    @JoinColumn(name = "account", referencedColumnName = "id")
    private Account account;

    private CurrencyEnum currency;

    private double totalAmount;

    private long groupWalletsId;
}
