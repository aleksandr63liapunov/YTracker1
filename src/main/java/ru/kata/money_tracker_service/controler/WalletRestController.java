package ru.kata.money_tracker_service.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.money_tracker_service.model.Wallet;
import ru.kata.money_tracker_service.service.WalletService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/wallets")
public class WalletRestController {
    private final WalletService walletService;

    public WalletRestController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Wallet>> restWalFindById(@PathVariable("id") long walletId) {
        return ResponseEntity.ok(walletService.findById(walletId));
    }

    @GetMapping
    public ResponseEntity<List<Wallet>> restWalFindAll() {
        return ResponseEntity.ok(walletService.findAll());
    }
    @PostMapping
    public ResponseEntity<Wallet> restWalFindSave(Wallet wallet) {
        return ResponseEntity.ok(walletService.save(wallet));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Wallet > restWalUpdate(Wallet wallet){
        return ResponseEntity.ok(walletService.update(wallet));
    }
    @DeleteMapping("/{id}")
    public void restWalDelete(long walletId){
        walletService.delete(walletId);
    }

}

