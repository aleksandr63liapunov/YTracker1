package ru.kata.money_tracker_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.money_tracker_service.model.Wallet;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    public Wallet findWalletByTitle(String title); // для тестирования
}