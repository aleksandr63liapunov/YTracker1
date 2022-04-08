package ru.kata.money_tracker_service.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private Long id;

    @NotEmpty(message = "User id should not be empty")
    private Long UserId;

    @NotEmpty(message = "Title should not be empty")
    private String Title;
}
