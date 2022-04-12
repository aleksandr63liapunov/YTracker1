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

        Account accountFromDB = accountRepository.findById(account.getId()).orElse(null); //?

        if (accountFromDB != null) {
            return accountFromDB;
        }
        accountRepository.save(account);
        return account;
    }

    @Override
    public Account update(Account account, long id) {

        account.setId(id);
        accountRepository.save(account);
        return account;
    }

    @Override
    public void delete(Long accountId) {

        if (accountRepository.findById(accountId).isPresent()) {
            accountRepository.deleteById(accountId);
        } else {
            accountRepository.delete(accountRepository.findById(accountId).get());
        }
    }

    public void deleteAll() {
        accountRepository.deleteAll();
    }
}
