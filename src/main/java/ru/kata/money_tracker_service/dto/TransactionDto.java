package ru.kata.money_tracker_service.dto;

import lombok.*;
import ru.kata.money_tracker_service.model.Tag;
import ru.kata.money_tracker_service.model.TypeOfTransation;
import ru.kata.money_tracker_service.model.Wallet;

import java.util.Calendar;
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TransactionDto {
    private Long id;
    private TypeOfTransation type;
    private  Double amountOfCurrency;
    private String blockNote;
    private Calendar calendar;
    private Wallet wallet;
    private Tag tag;
}
