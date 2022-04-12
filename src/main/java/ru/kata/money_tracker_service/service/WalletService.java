package ru.kata.money_tracker_service.service;

import ru.kata.money_tracker_service.model.Wallet;

import java.util.List;
import java.util.Optional;

public interface WalletService {

    Optional<Wallet> findById(long walletId);

    List<Wallet> findAll();

    Wallet save(Wallet wallet);

    Wallet update(Wallet wallet, long id);

    void delete(Long walletId);

    void deleteAll();
}
