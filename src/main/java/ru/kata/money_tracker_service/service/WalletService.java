package ru.kata.money_tracker_service.service;

import ru.kata.money_tracker_service.model.Wallet;

import java.util.List;
import java.util.Optional;

public interface WalletService {

    public Wallet findById(long walletId);

    public List<Wallet> findAll();

    public boolean save(Wallet wallet);

    public void update(Wallet wallet, long id);

    public boolean delete(Long walletId);

    //public Wallet findWalletByTitle(String title);
}
