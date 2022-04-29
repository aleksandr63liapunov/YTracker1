package ru.kata.money_tracker_service.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
//@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@EqualsAndHashCode()
@Table

public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Setter(value = AccessLevel.NONE)
    private Long id;

    public Transaction() {
    }

    public Transaction(TypeOfTransation type) {
        this.type = type;
    }

    public Transaction(TypeOfTransation type, String blockNote, Date date) {
        this.type = type;
        this.blockNote = blockNote;
        this.date = date;
    }

    public Transaction(String blockNote, Date date) {
        this.blockNote = blockNote;
        this.date = date;
    }

    public Transaction(TypeOfTransation type, String blockNote, Date date,Tag tag) {
        this.type = type;
        this.blockNote = blockNote;
        this.date = date;
        this.tag = tag;
    }
//    @OneToOne
//    @JoinColumn (name = "expense_wallet")
//    private Wallet expenseWallet;
//
//    @OneToOne
//    @JoinColumn(name = "income_wallet")
//    private Wallet incomeWallet;

    @Enumerated(EnumType.STRING)
    private TypeOfTransation type;

    @Column(name = "amount_of_currency")
    private Double amountOfCurrency;

    @Column
     private String blockNote;

    @Column
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account", referencedColumnName = "id")
//    @JsonManagedReference
    private Wallet wallet;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid", referencedColumnName = "id")
//    @JsonManagedReference
    private Tag tag;
}
