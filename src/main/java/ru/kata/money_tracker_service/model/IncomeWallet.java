package ru.kata.money_tracker_service.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode(exclude = {"id"})
public class IncomeWallet {
    @Id
    @Setter(value = AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Transaction transaction;


}
