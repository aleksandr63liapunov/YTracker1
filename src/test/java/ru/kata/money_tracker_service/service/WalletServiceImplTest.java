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
class WalletServiceImplTest {

    @Autowired
    private WalletServiceImpl walletService;

    public String randomText() {
        byte[] array = new byte[50]; // length is bounded by 50
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }

    Account accountTest = new Account();
    Wallet walletTest = new Wallet(0, randomText(), accountTest, CurrencyEnum.USD, 15.5, 15);
    Wallet walletTestId = new Wallet(0, randomText(), accountTest, CurrencyEnum.USD, 15.5, 15);
    Wallet walletTest1 = new Wallet();
    Wallet walletTest2 = new Wallet();
    Wallet walletTest3 = new Wallet();

    @Test
    void findById() {

        walletService.save(walletTestId);
        List<Wallet> walletList = walletService.findAll();

        try {
            Wallet wallet = walletList.get(walletList.size() - 1);

            if(!wallet.getTitle().equals(walletTestId.getTitle())) {
                Assertions.fail("WalletTest id: n, wallet id: " + wallet.getId());
            }
            System.out.println(wallet.getTitle());
        } catch (Exception e) {
            Assertions.fail("Save error: " +  e);
        } finally {
            walletService.deleteAll();
        }
    }

    @Test
    void findAll() {

        walletService.save(walletTest1);
        walletService.save(walletTest2);
        walletService.save(walletTest3);

        try {
            int listSize = walletService.findAll().size();
            if ( listSize != 3) {
                Assertions.assertEquals(0, listSize, "Expected list size 3");
            }
        } catch (Exception e) {
            Assertions.fail("Exception in method", e);
        } finally {
            walletService.deleteAll();
        }
    }

    @Test
    void save() {

        try {
            walletTest.setTitle(randomText());
            Wallet wallet = walletService.save(walletTest);
            if (!wallet.getTitle().equals(walletTest.getTitle())) {
                Assertions.fail("Save error");
            }
            List<Wallet> walletList = walletService.findAll();
            if(!walletList.get(walletList.size() - 1).getTitle().equals(walletTest.getTitle())) {
                Assertions.fail("Error in method");
            }
        } catch (Exception e) {
            Assertions.fail("Save error", e);
        } finally {
            walletService.deleteAll();
        }
    }

    @Test
    void update() {

        walletService.save(walletTest);
        walletService.save(walletTest1);
        walletService.save(walletTest2);
        walletService.save(walletTest3);

        List<Wallet> walletList = walletService.findAll();
        System.out.println(walletTest2.getTitle());
        long id = walletList.get(2).getId();

        Wallet updatedWallet = walletList.get(2);
        updatedWallet.setTitle(randomText());

        try {
            walletService.update(updatedWallet);
            System.out.println(updatedWallet.getTitle());
            if(updatedWallet.getId() != id) {
                Assertions.fail("Expected list size "  + id + " , but received " + updatedWallet.getId());
            }
            System.out.println(walletList.get(2).getId());
            System.out.println(updatedWallet.getId());
        } catch (Exception e) {
            Assertions.fail("Exception in method", e);
        }
    }

    @Test
    void delete() {

        walletService.deleteAll();
        walletService.save(walletTest);
        walletService.save(walletTest1);
        List<Wallet> walletList = walletService.findAll();

        try {
            Wallet wallet = walletList.get(walletList.size() - 1);
            walletService.delete(wallet.getId());
            List<Wallet> walletList1 = walletService.findAll();

            if(walletList1.size() != 1) {
               Assertions.fail("Expected list size 1, but received " + walletList1.size());
            }
        } catch (Exception e) {
            Assertions.fail("Exception in method", e);
        } finally {
            walletService.deleteAll();
        }
    }

    @Test
    void deleteAll() {

        int listSize = walletService.findAll().size();

        try {
            walletService.deleteAll();
            if(listSize != 0) {
                Assertions.assertEquals(0, listSize, "Expected list size 3");
            }
        } catch (Exception e) {
            Assertions.fail("Exception in method", e);
        }
    }
}