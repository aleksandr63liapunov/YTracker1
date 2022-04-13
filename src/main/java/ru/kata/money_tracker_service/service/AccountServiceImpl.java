package ru.kata.money_tracker_service.service;

import org.springframework.stereotype.Service;
import ru.kata.money_tracker_service.model.Account;
import ru.kata.money_tracker_service.repository.AccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<Account> findById(long accountId) {
        return accountRepository.findById(accountId);
    }

    @Override
    public List<Account> findAll() {

        return accountRepository.findAll();
    }

    @Override
    public Account save(Account account) {

        return accountRepository.save(account);
    }

    @Override
    public Account update(Account account) {

        return accountRepository.save(account);
    }

    @Override
    public void delete(Long accountId) {

        accountRepository.delete(accountRepository.findById(accountId).get());
    }

    public void deleteAll() {
        accountRepository.deleteAll();
    }
}
