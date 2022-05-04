package ru.kata.money_tracker_service.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@EqualsAndHashCode()
@Table

public class Transaction {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private Long id;

    @OneToOne
    @JoinColumn (name = "expense_wallet")
    private Wallet expenseWallet;

    @OneToOne
    @JoinColumn(name = "income_wallet")
    private Wallet incomeWallet;


    @Enumerated(EnumType.STRING)
    private TypeOfTransation type;

    @Column(name = "amount_of_currency")
    private Double amountOfCurrency;

    private String blockNote;

    private Calendar calendar;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wallet_id", referencedColumnName = "id")
    private Wallet wallet;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tag_id", referencedColumnName = "id")
    private Tag tag;

}
