package ru.kata.money_tracker_service.service;

import ru.kata.money_tracker_service.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    public Optional<Account> findById(long accountId);

    public List<Account> findAll();

    public boolean save(Account account);

    public void update(Account account, long id);

    public boolean delete(Long account);
}
