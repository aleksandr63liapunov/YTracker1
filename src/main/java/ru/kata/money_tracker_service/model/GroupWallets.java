package ru.kata.money_tracker_service.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter(value = AccessLevel.NONE)
@EqualsAndHashCode(exclude = {"id"})
public class GroupWallets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    private String title;

    @Setter
    private long AccountId;

    public GroupWallets(String title, long accountId) {
        this.title = title;
        AccountId = accountId;
    }
}
