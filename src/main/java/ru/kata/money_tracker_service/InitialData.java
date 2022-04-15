package ru.kata.money_tracker_service;


import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.kata.money_tracker_service.model.*;
import ru.kata.money_tracker_service.service.GroupWalletsService;
import ru.kata.money_tracker_service.service.TagService;
import ru.kata.money_tracker_service.service.TransactionService;
import ru.kata.money_tracker_service.service.WalletService;

@Component
public class InitialData implements ApplicationRunner {

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

        Wallet wallet1 = new Wallet(1L, "wallet_1", new Account(1L, 1L, true,
                CurrencyEnum.EUR, null), CurrencyEnum.EUR, 45000d, 1L);
        GroupWallets groupWallets1 = new GroupWallets(1L, "group_wallets_1", 1L);

        groupWalletsService.save(groupWallets1);
        walletService.save(wallet1);

        Wallet wallet2 = new Wallet(2L, "wallet_2", new Account(2L, 2L, false,
                CurrencyEnum.RUB, null), CurrencyEnum.RUB, 3015.1d, 2L);
        GroupWallets groupWallets2 = new GroupWallets(2L, "group_wallets_2", 2L);

        groupWalletsService.save(groupWallets2);
        walletService.save(wallet2);

        Wallet wallet3 = new Wallet(3L, "wallet_3", new Account(3L, 3L, false,
                CurrencyEnum.USD, null), CurrencyEnum.USD, 27000.5d, 3L);
        GroupWallets groupWallets3 = new GroupWallets(3L, "group_wallets_3", 3L);

        groupWalletsService.save(groupWallets3);
        walletService.save(wallet3);

        Wallet incomeWallet1 = new Wallet(
                0L, "income_wallet_title_1",
                new Account(0,1, false, CurrencyEnum.RUB, null),
                CurrencyEnum.RUB, 12200.5, 1);

        Wallet incomeWallet2 = new Wallet(
                0L, "income_wallet_title_2",
                new Account(0,2, true, CurrencyEnum.RUB, null),
                CurrencyEnum.RUB, 459800.9, 2);

        Wallet expenseWallet1 = new Wallet(
                0L, "expense_wallet_title_1",
                new Account(0,3, true, CurrencyEnum.EUR, null),
                CurrencyEnum.RUB, 1970.5, 2);


        Wallet expenseWallet2 = new Wallet(
                0L, "expense_wallet_title_2",
                new Account(0,4, false, CurrencyEnum.USD, null),
                CurrencyEnum.USD, 2301.7, 3);

        Transaction transaction1 = new Transaction(0L, expenseWallet2, incomeWallet2,
                TypeOfTransation.EXPENSE, 985.0);

        Transaction transaction2 = new Transaction(0L, expenseWallet1, incomeWallet1,
                TypeOfTransation.TRANSFER, 985.0);

        walletService.save(expenseWallet1);
        walletService.save(expenseWallet2);
        walletService.save(incomeWallet1);
        walletService.save(incomeWallet2);

        transactionService.save(transaction1);
        transactionService.save(transaction2);


        Tag tag1 = new Tag(0L, 1L, "tag_title_1");
        Tag tag2 = new Tag(0L, 2L, "tag_title_2");

        tagService.save(tag1);
        tagService.save(tag2);

    }

}
