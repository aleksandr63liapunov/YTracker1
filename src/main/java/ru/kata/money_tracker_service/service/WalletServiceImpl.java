package ru.kata.money_tracker_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.money_tracker_service.model.Wallet;
import ru.kata.money_tracker_service.repository.AccountRepository;
import ru.kata.money_tracker_service.repository.WalletRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class WalletServiceImpl implements WalletService{

    @PersistenceContext
    private EntityManager em;

    final WalletRepository walletRepository;

    @Autowired
    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Optional<Wallet> findById(long walletId) {
        return walletRepository.findById(walletId);
    }

    public List<Wallet> findAll() {
        return walletRepository.findAll();
    }

    public boolean save(Wallet wallet) {
        Wallet walletFromDB = walletRepository.findById(wallet.getId()).orElse(null); //?

        if (walletFromDB != null) {
            return false;
        }
        walletRepository.save(wallet);
        return true;
    }

    public void update(Wallet wallet, long id) {

        wallet.setId(id);
        walletRepository.save(wallet);
    }

    public boolean delete(Long walletId) {

        if (walletRepository.findById(walletId).isPresent()) {
            walletRepository.deleteById(walletId);
            return true;
        }
        return false;
    }

//    @Override
//    public Wallet findWalletByTitle(String title) {
//
//        return walletRepository.findWalletByTitle(title);
//    }

    public void deleteAll() {
        walletRepository.deleteAll();
    }
}
