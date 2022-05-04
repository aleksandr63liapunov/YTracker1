package ru.kata.money_tracker_service.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.money_tracker_service.dto.TransactionDto;
import ru.kata.money_tracker_service.model.Transaction;
import ru.kata.money_tracker_service.service.TransactionService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transactions")
public class TransactionRestController {
    private final TransactionService transactionService;

    public TransactionRestController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    private TransactionDto transactionToDto (Transaction transaction){
        return  TransactionDto.builder()
                .id(transaction.getId())
                .type(transaction.getType())
                .calendar(transaction.getCalendar())
                .blockNote(transaction.getBlockNote())
                .wallet(transaction.getWallet())
                .tag(transaction.getTag())
                .build();
    }

    @GetMapping("/dto_get_all")
    public List<TransactionDto> restTransDTOFindAll() {
        return transactionService.findAll()
                .stream()
                .map(this::transactionToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/dto_add")
    public ResponseEntity<TransactionDto> restTransDTOSave (@RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionToDto(transactionService.save(transaction)));
    }

    @PostMapping
    public ResponseEntity<Transaction> restTransSave(Transaction transaction) {
        transactionService.save(transaction);
        return ResponseEntity.ok(transaction);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> restTransFindAll() {
        return ResponseEntity.ok(transactionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Transaction>> restTransFindById(@PathVariable("id") long transactionId) {

        Optional<Transaction> transaction = transactionService.findById(transactionId);
        if (transaction.isPresent()) {

            return ResponseEntity.ok(transaction);
        }
        return ResponseEntity.badRequest().build();
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