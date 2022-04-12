package ru.kata.money_tracker_service.service;

import ru.kata.money_tracker_service.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    Optional<Account> findById(long accountId);

    List<Account> findAll();

    Account save(Account account);

    Account update(Account account);

    void delete(Long account);

    void deleteAll();
}
