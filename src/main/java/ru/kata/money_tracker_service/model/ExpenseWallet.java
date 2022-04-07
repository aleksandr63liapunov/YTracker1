package ru.kata.money_tracker_service.model;

import javax.persistence.*;

@Entity
public class ExpenseWallet {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Transaction transaction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
