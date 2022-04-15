package ru.kata.money_tracker_service.service;

import ru.kata.money_tracker_service.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {

    Optional<Transaction> findById(long transactionId);

    List<Transaction> findAll();

    Transaction save(Transaction transaction);

    Transaction update(Transaction transaction);

    void delete(Long transactionId);

    void deleteAll();

}
