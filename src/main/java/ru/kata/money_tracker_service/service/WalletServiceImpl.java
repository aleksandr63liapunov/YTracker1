package ru.kata.money_tracker_service.service;

import org.springframework.stereotype.Service;
import ru.kata.money_tracker_service.model.Wallet;
import ru.kata.money_tracker_service.repository.WalletRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService{

    private final WalletRepository walletRepository;

    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Optional<Wallet> findById(long walletId) {
        return walletRepository.findById(walletId);
    }

    public List<Wallet> findAll() {
        return walletRepository.findAll();
    }

    public Wallet save(Wallet wallet) {

        return walletRepository.save(wallet);
    }

    public Wallet update(Wallet wallet) {

        return walletRepository.save(wallet);
    }

    public void delete(Long walletId) {

        walletRepository.delete(walletRepository.findById(walletId).get());
    }

    public void deleteAll() {
        walletRepository.deleteAll();
    }
}
