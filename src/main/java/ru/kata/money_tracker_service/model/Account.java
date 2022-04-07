package ru.kata.money_tracker_service.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter(value = AccessLevel.NONE)
@EqualsAndHashCode(exclude = {"id", "userId"})
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @NotEmpty
    @NotBlank
    @Setter
    private boolean isMainUser;

    @Enumerated(EnumType.STRING)
    @Setter
    private CurrencyEnum mainCurrency;

    @OneToOne(mappedBy = "account", targetEntity = Wallet.class)
    @Setter
    private Wallet wallet;

    public Account(boolean isMainUser, CurrencyEnum mainCurrency, Wallet wallet) {
        this.isMainUser = isMainUser;
        this.mainCurrency = mainCurrency;
        this.wallet = wallet;
    }
}
