package ru.kata.money_tracker_service.model;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Tag")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(value = AccessLevel.NONE)
    private Long id;

    @NotEmpty(message = "UserId should not be empty")
    private Long UserId;

    @NotEmpty(message = "Title should not be empty")
    private String Title;
}
