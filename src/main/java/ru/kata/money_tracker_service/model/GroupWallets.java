package ru.kata.money_tracker_service.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor @AllArgsConstructor @Getter @EqualsAndHashCode
public class GroupWallets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private long id;

    @Setter
    private String title;

    private long AccountId;

    public GroupWallets(String title, long accountId) {
        this.title = title;
        AccountId = accountId;
    }
}
