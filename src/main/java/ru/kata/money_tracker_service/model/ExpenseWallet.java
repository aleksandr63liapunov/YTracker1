package ru.kata.money_tracker_service.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter(value = AccessLevel.NONE)
@EqualsAndHashCode(exclude = {"id"})
public class ExpenseWallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Transaction transaction;


}
