package ru.kata.money_tracker_service.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.money_tracker_service.model.Transaction;
import ru.kata.money_tracker_service.service.TransactionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transaction")
public class TransactionRestController {
    private final TransactionService transactionService;

    public TransactionRestController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Transaction>> restTransFindById(@PathVariable("id") long transactionId) {

        Optional<Transaction> transaction = transactionService.findById(transactionId);
        if (transaction.isPresent()) {

            return ResponseEntity.ok(transaction);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> restTransFindAll() {
        return ResponseEntity.ok(transactionService.findAll());
    }

    @PostMapping
    public ResponseEntity<Transaction> restTransSave(@RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionService.save(transaction));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> restTransUpdate(@RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionService.update(transaction));
    }

    @DeleteMapping("/{id}")
    public void restDelete(@PathVariable("id") Long transactionId) {
        transactionService.delete(transactionId);
    }

}
