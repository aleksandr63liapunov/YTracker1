package ru.kata.money_tracker_service.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"id"})
public class GroupWallets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private long id;

    private String title;

    private long AccountId;

    public GroupWallets(String title, long accountId) {
        this.title = title;
        AccountId = accountId;
    }
}
