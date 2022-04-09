package ru.kata.money_tracker_service.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode()
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private long id;

    @Setter(value = AccessLevel.NONE)
    private long userId;

    @NotEmpty
    @NotBlank
    private boolean isMainUser;

    @Enumerated(EnumType.STRING)
    private CurrencyEnum mainCurrency;

    @OneToOne(mappedBy = "account", targetEntity = Wallet.class)
    private Wallet wallet;
}
