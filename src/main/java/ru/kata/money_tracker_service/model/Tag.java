package ru.kata.money_tracker_service.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "User id should not be empty")
    private Long userId;

    @NotEmpty(message = "Title should not be empty")
    private String titleT;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "tag")
    @JsonBackReference
    private Set<Transaction> transaction;


}
