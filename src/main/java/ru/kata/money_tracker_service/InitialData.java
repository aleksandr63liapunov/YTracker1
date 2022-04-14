package ru.kata.money_tracker_service;


import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.kata.money_tracker_service.model.Account;
import ru.kata.money_tracker_service.model.CurrencyEnum;
import ru.kata.money_tracker_service.model.GroupWallets;
import ru.kata.money_tracker_service.model.Wallet;
import ru.kata.money_tracker_service.service.GroupWalletsService;
import ru.kata.money_tracker_service.service.WalletService;

@Component
public class InitialData implements ApplicationRunner {

    private final WalletService walletService;
    private final GroupWalletsService groupWalletsService;

    public InitialData(WalletService walletService, GroupWalletsService groupWalletsService) {
        this.walletService = walletService;
        this.groupWalletsService = groupWalletsService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Wallet wallet1 = new Wallet(1L, "wallet_1", 1L, new Account(1L, 1L, true,
                CurrencyEnum.EUR, null), CurrencyEnum.EUR, 45000d, 1L);
        GroupWallets groupWallets1 = new GroupWallets(1L, "group_wallets_1", 1L);

        groupWalletsService.save(groupWallets1);
        walletService.save(wallet1);

        Wallet wallet2 = new Wallet(2L, "wallet_2", 2L, new Account(2L, 2L, false,
                CurrencyEnum.RUB, null), CurrencyEnum.RUB, 3015.1d, 2L);
        GroupWallets groupWallets2 = new GroupWallets(2L, "group_wallets_2", 2L);

        groupWalletsService.save(groupWallets2);
        walletService.save(wallet2);

        Wallet wallet3 = new Wallet(3L, "wallet_3", 3L, new Account(3L, 3L, false,
                CurrencyEnum.USD, null), CurrencyEnum.USD, 27000.5d, 3L);
        GroupWallets groupWallets3 = new GroupWallets(3L, "group_wallets_3", 3L);

        groupWalletsService.save(groupWallets3);
        walletService.save(wallet3);
    }
}
