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
    private long id;

    private long userId;

    @NotEmpty
    @NotBlank
    private boolean isMainUser;

    @Enumerated(EnumType.STRING)
    private CurrencyEnum mainCurrency;

    @OneToOne(mappedBy = "account")
    private Wallet wallet;
}
