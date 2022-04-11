package ru.kata.money_tracker_service.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kata.money_tracker_service.model.Account;
import ru.kata.money_tracker_service.model.CurrencyEnum;
import ru.kata.money_tracker_service.model.Wallet;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
class AccountServiceImplTest {

    @Autowired
    private AccountServiceImpl accountService;

    public String randomText() {
        byte[] array = new byte[50]; // length is bounded by 50
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }

    Account accountEmpty = new Account();
    Wallet wallet = new Wallet(0, randomText(), 15, accountEmpty, CurrencyEnum.USD, 15.5, 15);
    Wallet wallet1 = new Wallet();
    Account accountTest = new Account(0, 1L, true, CurrencyEnum.USD, wallet);
    Account accountTest1 = new Account();
    Account accountTest2 = new Account();
    Account accountTest3 = new Account();

    @Test
    void findById() {

        accountService.save(accountTest);
        List<Account> accountList = accountService.findAll();

        try {
            Account account = accountList.get(accountList.size() - 1);

            if(!account.getWallet().getTitle().equals(wallet.getTitle())) {
                Assertions.fail("AccountTest id: n, account id: " + account.getId());
            }
            System.out.println(account.getWallet().getTitle());
        } catch (Exception e) {
            Assertions.fail("Save error: " +  e);
        } finally {
            accountService.deleteAll();
        }
    }

    @Test
    void findAll() {

        accountService.save(accountTest1);
        accountService.save(accountTest2);
        accountService.save(accountTest3);

        try {
            int listSize = accountService.findAll().size();
            if ( listSize != 3) {
                Assertions.assertEquals(0, listSize, "Expected list size 3");
            }
        } catch (Exception e) {
            Assertions.fail("Exception in method", e);
        } finally {
            accountService.deleteAll();
        }
    }

    @Test
    void save() {

        try {
            //accountTest.setWallet(wallet);
            if (!accountService.save(accountTest)) {
                Assertions.fail("Save error");
            }
            List<Account> accountList = accountService.findAll();
            if(!accountList.get(accountList.size() - 1).getWallet().getTitle().equals(wallet.getTitle())) {
                Assertions.fail("Error in method");
            }
        } catch (Exception e) {
            Assertions.fail("Save error", e);
        } finally {
            accountService.deleteAll();
        }
    }

    @Test
    void update() {

        accountService.save(accountTest);
        accountService.save(accountTest1);
        accountService.save(accountTest2);
        accountService.save(accountTest3);

        List<Account> accountList = accountService.findAll();
        System.out.println(accountTest2.getWallet());
        long id = accountList.get(2).getId();

        Account updatedAccount = accountList.get(2);
        updatedAccount.setWallet(wallet1);

        try {
            accountService.update(updatedAccount, updatedAccount.getId());
            System.out.println(updatedAccount.getWallet());
            if(updatedAccount.getId() != id) {
                Assertions.fail("Expected list size 1, but received " + updatedAccount.getId());
            }
            System.out.println(accountList.get(2).getId());
            System.out.println(updatedAccount.getId());
        } catch (Exception e) {
            Assertions.fail("Exception in method", e);
        }
    }

    @Test
    void delete() {

        accountService.save(accountTest1);
        accountService.save(accountTest2);
        List<Account> accountList = accountService.findAll();

        try {
            Account account = accountList.get(accountList.size() - 1);
            accountService.delete(account.getId());
            List<Account> accountList1 = accountService.findAll();

            if(accountList1.size() != 1) {
                Assertions.fail("Expected list size 1, but received " + accountList1.size());
            }
        } catch (Exception e) {
            Assertions.fail("Exception in method", e);
        } finally {
            accountService.deleteAll();
        }
    }

    @Test
    void deleteAll() {

        int listSize = accountService.findAll().size();

        try {
            accountService.deleteAll();
            if(listSize != 0) {
                Assertions.assertEquals(0, listSize, "Expected list size 3");
            }
        } catch (Exception e) {
            Assertions.fail("Exception in method", e);
        }
    }
}