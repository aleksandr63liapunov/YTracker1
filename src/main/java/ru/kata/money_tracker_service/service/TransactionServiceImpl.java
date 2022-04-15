package ru.kata.money_tracker_service.service;

import org.springframework.stereotype.Service;
import ru.kata.money_tracker_service.model.Transaction;
import ru.kata.money_tracker_service.repository.TransactionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;

    public TransactionServiceImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Transaction> findById(long transactionId) {
        return repository.findById(transactionId);
    }

    @Override
    public List<Transaction> findAll() {
        return repository.findAll();
    }

    @Override
    public Transaction save(Transaction transaction) {
        return repository.save(transaction);
    }

    @Override
    public Transaction update(Transaction transaction) {
        return repository.save(transaction);
    }

    @Override
    public void delete(Long transactionId) {
        repository.deleteById(transactionId);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
