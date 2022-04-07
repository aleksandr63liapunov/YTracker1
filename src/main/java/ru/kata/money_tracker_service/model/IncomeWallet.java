package ru.kata.money_tracker_service.model;

<<<<<<< HEAD
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
=======
import javax.persistence.*;

@Entity
public class IncomeWallet {
    @Id
    @Column(name = "id", nullable = false)
>>>>>>> b3a2af47c613e0f77e54eb0712061eb15056d6a2
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Transaction transaction;


}
