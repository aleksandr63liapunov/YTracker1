package ru.kata.money_tracker_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.money_tracker_service.model.Account;
import ru.kata.money_tracker_service.model.Wallet;
import ru.kata.money_tracker_service.repository.AccountRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    @PersistenceContext
    private EntityManager em;

    final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {

        this.accountRepository = accountRepository;
    }

    @Override
    public Account findById(long accountId) {

        Optional<Account> walletFromDB = accountRepository.findById(accountId);
        return walletFromDB.orElse(null); //?
    }

    @Override
    public List<Account> findAll() {

        return accountRepository.findAll();
    }

    @Override
    public boolean save(Account account) {

        Account accountFromDB = accountRepository.findById(account.getId()).orElse(null); //?

        if (accountFromDB != null) {
            return false;
        }
        accountRepository.save(account);
        return true;
    }

    @Override
    public void update(Account account, long id) {

        account.setId(id);
        accountRepository.save(account);
    }

    @Override
    public boolean delete(Long accountId) {

        if (accountRepository.findById(accountId).isPresent()) {
            accountRepository.deleteById(accountId);
            return true;
        }
        return false;
    }
}
