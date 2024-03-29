package ru.kata.money_tracker_service.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kata.money_tracker_service.model.*;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class TransactionServiceImplTest {

    @Autowired
    private TransactionServiceImpl transactionService;
    @Autowired
    private WalletServiceImpl walletService;

    Set<Transaction> transactions=new HashSet<>() ;
    private final Wallet incomeWallet1 = new Wallet(1L, "wallet_1", new Account(1L, 1L, true,
            CurrencyEnum.EUR, null), CurrencyEnum.EUR, 45000d, 1L);

    private final Wallet incomeWallet2 = new Wallet(
            1L, "wallet_1", new Account(1L, 1L, true,
            CurrencyEnum.EUR, null), CurrencyEnum.EUR, 45000d, 1L);

    private final Wallet expenseWallet1 = new Wallet(
            1L, "wallet_1", new Account(1L, 1L, true,
            CurrencyEnum.EUR, null), CurrencyEnum.EUR, 45000d, 1L);


    private final Wallet expenseWallet2 = new Wallet(
            1L, "wallet_1", new Account(1L, 1L, true,
            CurrencyEnum.EUR, null), CurrencyEnum.EUR, 45000d, 1L);

    private final Transaction transaction1 = new Transaction(0L, expenseWallet2, incomeWallet2,
            TypeOfTransation.EXPENSE, 985.0, "blocNote2",new GregorianCalendar(), incomeWallet2,new Tag(1L,1L,"title1"));

    private final Transaction transaction2 = new Transaction(0L, expenseWallet2, incomeWallet2,
            TypeOfTransation.EXPENSE, 985.0, "blocNote2",new GregorianCalendar(), incomeWallet2,new Tag(1L,1L,"title1"));

    void initDB() {
        walletService.save(expenseWallet1);
        walletService.save(expenseWallet2);
        walletService.save(incomeWallet1);
        walletService.save(incomeWallet2);

    }

    @Test
    void save() {
        initDB();
        transactionService.save(transaction1);
        transactionService.save(transaction2);
        transactionService.deleteAll();
    }

    @Test
    void update() {
        initDB();
        transactionService.save(transaction1);
        long id = transactionService.findAll().get(0).getId();
        Transaction transaction = transactionService.findById(id).orElse(null);
        assert transaction != null;
        transaction.setType(TypeOfTransation.INCOME);
        transactionService.update(transaction);

        Transaction updateTransaction = transactionService.findAll().get(0);
        if (!Objects.equals(transaction.getType(), updateTransaction.getType())) {
            Assertions.fail("objects are different, update");
        }
        transactionService.deleteAll();
    }

    @Test
    void findById() {
        initDB();
        transactionService.save(transaction1);
        long id = transactionService.findAll().get(0).getId();
        Transaction transactionFromDb = transactionService.findById(id).orElse(null);
        assert transactionFromDb != null;
        if (transactionFromDb.getId() != id ) {
            Assertions.fail("objects are different, findById");
        }
        transactionService.deleteAll();

    }

    @Test
    void findAll() {
        initDB();
        transactionService.save(transaction1);
        transactionService.save(transaction2);
        List<Transaction> list = transactionService.findAll();

        if (list.size() != 2) {
            Assertions.fail("findAll doesn't work, List.size() = " + list.size());
        }
        transactionService.deleteAll();
    }

    @Test
    void deleteById() {
        initDB();
        transactionService.save(transaction1);
        transactionService.save(transaction2);
        long id1 = transactionService.findAll().get(0).getId();
        long id2 = transactionService.findAll().get(1).getId();
        transactionService.delete(id1);
        transactionService.delete(id2);
        List<Transaction> list = transactionService.findAll();
        if (list.size() != 0) {
            Assertions.fail("deleteById doesn't work");
        }
        transactionService.deleteAll();
    }

    @Test
    void deleteAll() {
        initDB();
        transactionService.save(transaction1);
        transactionService.save(transaction2);
        transactionService.deleteAll();
        List<Transaction> list = transactionService.findAll();
        if (list.size() != 0) {
            Assertions.fail("deleteAll doesn't work");
        }
    }}
