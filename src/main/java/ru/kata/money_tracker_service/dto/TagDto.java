package ru.kata.money_tracker_service.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TagDto {

    private Long id;

    private String titleT;
}
