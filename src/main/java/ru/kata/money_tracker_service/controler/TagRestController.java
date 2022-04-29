package ru.kata.money_tracker_service.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.money_tracker_service.model.Tag;
import ru.kata.money_tracker_service.model.Wallet;
import ru.kata.money_tracker_service.repository.TagRepository;
import ru.kata.money_tracker_service.service.TagService;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/tags")
public class TagRestController {
    private final TagRepository tagService;

    public TagRestController(TagRepository tagService) {
        this.tagService = tagService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Tag>> restTagFindById(@PathVariable("id") long tagId) {
        return ResponseEntity.ok(tagService.findById(tagId));
    }

    @GetMapping
    public List<Tag> restTagFindAll() {
        return tagService.findAll();
    }



    @PostMapping
    public ResponseEntity<Tag> restWalFindSave(Tag tag) {

        return ResponseEntity.ok(tagService.save(tag));
    }
//    @PutMapping("/{id}")
//    public ResponseEntity<Wallet > restWalUpdate(Wallet wallet){
//        return ResponseEntity.ok(walletService.update(wallet));
//    }
//    @DeleteMapping("/{id}")
//    public void restWalDelete(long walletId){
//        walletService.delete(walletId);
//    }
}
