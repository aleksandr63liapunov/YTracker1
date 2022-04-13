package ru.kata.money_tracker_service.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kata.money_tracker_service.model.GroupWallets;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
class GroupWalletsServiceImplTest {

    @Autowired
    private GroupWalletsServiceImpl groupWalletService;

    public String randomText() {
        byte[] array = new byte[50]; // length is bounded by 50
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }

    GroupWallets groupWalletTest = new GroupWallets(0, randomText(), 1L);
    GroupWallets groupWalletTestId = new GroupWallets(0, randomText(), 1L);
    GroupWallets groupWalletTest1 = new GroupWallets();
    GroupWallets groupWalletTest2 = new GroupWallets();
    GroupWallets groupWalletTest3 = new GroupWallets();

    @Test
    void findById() {

        groupWalletService.save(groupWalletTestId);
        List<GroupWallets> walletList = groupWalletService.findAll();

        try {
            GroupWallets wallet = walletList.get(walletList.size() - 1);
            if(!wallet.getTitle().equals(groupWalletTestId.getTitle())) {
                Assertions.fail("GroupWalletTest id: n, wallet id: " + wallet.getId());
            }
            System.out.println(wallet.getTitle());
        } catch (Exception e) {
            Assertions.fail("Save error: " +  e);
        } finally {
            groupWalletService.deleteAll();
        }
    }

    @Test
    void findAll() {

        groupWalletService.save(groupWalletTest1);
        groupWalletService.save(groupWalletTest2);
        groupWalletService.save(groupWalletTest3);

        try {
            int listSize = groupWalletService.findAll().size();
            if ( listSize != 3) {
                Assertions.assertEquals(0, listSize, "Expected list size 3");
            }
        } catch (Exception e) {
            Assertions.fail("Exception in method", e);
        } finally {
            groupWalletService.deleteAll();
        }
    }

    @Test
    void save() {

        try {
            groupWalletTest.setTitle(randomText());
            GroupWallets groupWallets = groupWalletService.save(groupWalletTest);
            if (!groupWallets.getTitle().equals(groupWalletTest.getTitle())) {
                Assertions.fail("Save error");
            }
            List<GroupWallets> walletList = groupWalletService.findAll();
            if(!walletList.get(walletList.size() - 1).getTitle().equals(groupWalletTest.getTitle())) {
                Assertions.fail("Error in method");
            }
        } catch (Exception e) {
            Assertions.fail("Save error", e);
        } finally {
            groupWalletService.deleteAll();
        }
    }

    @Test
    void update() {

        groupWalletService.save(groupWalletTest);
        groupWalletService.save(groupWalletTest1);
        groupWalletService.save(groupWalletTest2);
        groupWalletService.save(groupWalletTest3);

        List<GroupWallets> walletList = groupWalletService.findAll();
        System.out.println(groupWalletTest2.getTitle());
        long id = walletList.get(2).getId();

        GroupWallets updatedWallet = walletList.get(2);
        updatedWallet.setTitle(randomText());

        try {
            groupWalletService.update(updatedWallet);
            System.out.println(updatedWallet.getTitle());
            if(updatedWallet.getId() != id) {
                Assertions.fail("Expected list size " + id + " , but received " + updatedWallet.getId());
            }
            System.out.println(walletList.get(2).getId());
            System.out.println(updatedWallet.getId());
        } catch (Exception e) {
            Assertions.fail("Exception in method", e);
        }
    }

    @Test
    void delete() {

        groupWalletService.save(groupWalletTest);
        groupWalletService.save(groupWalletTest1);
        List<GroupWallets> walletList = groupWalletService.findAll();

        try {
            GroupWallets wallet = walletList.get(walletList.size() - 1);
            groupWalletService.delete(wallet.getId());
            List<GroupWallets> walletList1 = groupWalletService.findAll();

            if(walletList1.size() != 1) {
                Assertions.fail("Expected list size 1, but received " + walletList1.size());
            }
        } catch (Exception e) {
            Assertions.fail("Exception in method", e);
        } finally {
            groupWalletService.deleteAll();
        }
    }

    @Test
    void deleteAll() {

        int listSize = groupWalletService.findAll().size();

        try {
            groupWalletService.deleteAll();
            if(listSize != 0) {
                Assertions.assertEquals(0, listSize, "Expected list size 3");
            }
        } catch (Exception e) {
            Assertions.fail("Exception in method", e);
        }
    }
}