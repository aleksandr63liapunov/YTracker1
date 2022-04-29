package ru.kata.money_tracker_service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import ru.kata.money_tracker_service.model.*;
import ru.kata.money_tracker_service.service.GroupWalletsService;
import ru.kata.money_tracker_service.service.TagService;
import ru.kata.money_tracker_service.service.TransactionService;
import ru.kata.money_tracker_service.service.WalletService;

import java.util.*;

@Component
@PropertySource("classpath:application.yml")
public class InitialData implements ApplicationRunner {

    @Autowired
    private Environment env;

    private final WalletService walletService;
    private final GroupWalletsService groupWalletsService;
    private final TransactionService transactionService;
    private final TagService tagService;

    public InitialData(WalletService walletService,
                       GroupWalletsService groupWalletsService,
                       TransactionService transactionService,
                       TagService tagService) {

        this.walletService = walletService;
        this.groupWalletsService = groupWalletsService;
        this.transactionService = transactionService;
        this.tagService = tagService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String ddl = env.getProperty("spring.jpa.hibernate.ddl-auto");
        if (ddl.equals("create") || ddl.equals("create-drop")) {

            Transaction transaction1=new Transaction(1L,TypeOfTransation.EXPENSE,3D,"qqq",new Date(2021,12,12),new Wallet(),new Tag());
            transactionService.save(transaction1);
            Transaction transaction2=new Transaction(2L,TypeOfTransation.INCOME,4D,"www",new Date(2021,12,11),new Wallet(),new Tag());
            transactionService.save(transaction2);
            Transaction transaction3=new Transaction(3L,TypeOfTransation.TRANSFER,5D,"eee",new Date(2020,12,11),new Wallet(),new Tag());
            transactionService.save(transaction3);
//

 Set<Transaction> transactions=new HashSet<>() ;
//            Wallet wallet1=new Wallet(1L,"qqq",new Account(),CurrencyEnum.RUB,3D,1L,transactions);
//walletService.save(wallet1);
//
            Wallet wallet1=new Wallet();
            wallet1.setTitle("titlewallet1");
            wallet1.setCurrency(CurrencyEnum.RUB);
            wallet1.setGroupWalletsId(1L);
            wallet1.setAccount(new Account(1L, 1L, true,
                    CurrencyEnum.EUR, null));
            wallet1.setTotalAmount(100);
            wallet1.setTransaction(transactions);
            wallet1.setId(1L);
            walletService.save(wallet1);



            GroupWallets groupWallets1 = new GroupWallets(1L, "group_wallets_1", 1L);
            groupWalletsService.save(groupWallets1);
            GroupWallets groupWallets2 = new GroupWallets(2L, "group_wallets_2", 2L);
            groupWalletsService.save(groupWallets2);
            GroupWallets groupWallets3 = new GroupWallets(3L, "group_wallets_3", 3L);
            groupWalletsService.save(groupWallets3);


            Wallet wallet2=new Wallet();
            wallet2.setTitle("titlewallet2");
            wallet2.setCurrency(CurrencyEnum.RUB);
            wallet2.setGroupWalletsId(2L);
            wallet2.setAccount(new Account(2L, 2L, true,
                    CurrencyEnum.USD, null));
            wallet2.setTotalAmount(200);
            wallet2.setTransaction(transactions);
            wallet2.setId(2L);
            walletService.save(wallet2);

            Wallet wallet3=new Wallet();
            wallet3.setTitle("titlewallet3");
            wallet3.setCurrency(CurrencyEnum.RUB);
            wallet3.setGroupWalletsId(3L);
            wallet3.setAccount(new Account(3L, 3L, true,
                    CurrencyEnum.USD, null));
            wallet3.setTotalAmount(300);
            wallet3.setTransaction(transactions);
            wallet3.setId(3L);
            walletService.save(wallet3);


            Tag tag1=new Tag();
            tag1.setTransaction(transactions);
            tag1.setId(1L);
            tag1.setUserId(1L);
            tag1.setTitleT("titletag1");
            tagService.save(tag1);

            Tag tag2=new Tag();
            tag2.setTransaction(transactions);
            tag2.setId(2L);
            tag2.setUserId(2L);
            tag2.setTitleT("titletag2");
            tagService.save(tag2);

            Tag tag3=new Tag();
            tag3.setTransaction(transactions);
            tag3.setId(3L);
            tag3.setUserId(3L);
            tag3.setTitleT("titletag3");
            tagService.save(tag3);


        }


//            Wallet wallet1 = new Wallet(1L, "wallet_1", new Account(1L, 1L, true,
//                    CurrencyEnum.EUR, null), CurrencyEnum.EUR, 45000d, 1L,  new Transaction(1L,
//                    TypeOfTransation.EXPENSE,1D,"qqq" , new Date(2021,12,01), new Wallet(),new Tag(1L, 1L, "titlet1",new Transaction() )) );
//            GroupWallets groupWallets1 = new GroupWallets(1L, "group_wallets_1", 1L);
//
//            groupWalletsService.save(groupWallets1);
//            walletService.save(wallet1);
//
//            Wallet wallet2 = new Wallet(2L, "wallet_2", new Account(2L, 2L, false,
//                    CurrencyEnum.RUB, null), CurrencyEnum.RUB, 3015.1d, 2L,(List<Transaction>) new Transaction());
//            GroupWallets groupWallets2 = new GroupWallets(2L, "group_wallets_2", 2L);
//
//            groupWalletsService.save(groupWallets2);
//            walletService.save(wallet2);
//
//            Wallet wallet3 = new Wallet(3L, "wallet_3", new Account(3L, 3L, false,
//                    CurrencyEnum.USD, null), CurrencyEnum.USD, 27000.5d, 3L,new Tag(3L, 3L, "titlet3", new Wallet()));
//            GroupWallets groupWallets3 = new GroupWallets(3L, "group_wallets_3", 3L);
//
//            groupWalletsService.save(groupWallets3);
//            walletService.save(wallet3);
//
//            Wallet incomeWallet1 = new Wallet(
//                    0L, "income_wallet_title_1",
//                    new Account(0, 1, false, CurrencyEnum.RUB, null),
//                    CurrencyEnum.RUB, 12200.5, 1,new Tag(4L, 4L, "titlet4", new Wallet()));
//
//            Wallet incomeWallet2 = new Wallet(
//                    0L, "income_wallet_title_2",
//                    new Account(0, 2, true, CurrencyEnum.RUB, null),
//                    CurrencyEnum.RUB, 459800.9, 2,new Tag(5L, 5L, "titlet5", new Wallet()));
//
//            Wallet expenseWallet1 = new Wallet(
//                    0L, "expense_wallet_title_1",
//                    new Account(0, 3, true, CurrencyEnum.EUR, null),
//                    CurrencyEnum.RUB, 1970.5, 2,new Tag(6L, 6L, "titlet6", new Wallet()));
//
//
//            Wallet expenseWallet2 = new Wallet(
//                    0L, "expense_wallet_title_2",
//                    new Account(0, 4, false, CurrencyEnum.USD, null),
//                    CurrencyEnum.USD, 2301.7, 3,new Tag(7L, 7L, "titlet7", new Wallet()));
//
//            Transaction transaction1 = new Transaction(1L,
//                    TypeOfTransation.EXPENSE,1D,"qqq" , new Date(2021,12,01), wallet3,new Tag(1L, 1L, "titlet1", ));
//
//            Transaction transaction2 = new Transaction(2L,
//                    TypeOfTransation.TRANSFER, 2D,"www",new Date(2022,12,01), wallet1);
//
//            Transaction transaction3 = new Transaction(3L,
//                    TypeOfTransation.INCOME, 3D,"rrr",new Date(2023,12,01), wallet2);
//
//            walletService.save(expenseWallet1);
//            walletService.save(expenseWallet2);
//            walletService.save(incomeWallet1);
//            walletService.save(incomeWallet2);
//
//            transactionService.save(transaction1);
//            transactionService.save(transaction2);
//            transactionService.save(transaction3);
//
//            Tag tag1 = new Tag(0L, 1L, "tag_title_1", transaction1);
//            Tag tag2 = new Tag(0L, 2L, "tag_title_2", wallet2);
//
//            tagService.save(tag1);
//            tagService.save(tag2);
//        }
    }
}