package ru.kata.money_tracker_service.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.money_tracker_service.dto.TagDto;
import ru.kata.money_tracker_service.model.Tag;
import ru.kata.money_tracker_service.model.Wallet;
import ru.kata.money_tracker_service.repository.TagRepository;
import ru.kata.money_tracker_service.service.TagService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tags")
public class TagRestController {

    private final TagService tagService;

    public TagRestController(TagService tagService) {
        this.tagService = tagService;
    }

    private TagDto tagToDto (Tag tag){
        return  TagDto.builder()
                .id(tag.getId())
                //.userId(tag.getUserId())
                .titleT(tag.getTitle())
                .build();
    }
    @PostMapping("/dto_add")
    public ResponseEntity<TagDto> restTransSave (@RequestBody Tag tag) {
        return ResponseEntity.ok(tagToDto(tagService.save(tag)));
    }

    @GetMapping("/dto_get_all")
    public List<TagDto> restTagDTOFindAll() {
        return tagService.findAll()
                .stream()
                .map(this::tagToDto)
                .collect(Collectors.toList());
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
    public ResponseEntity<Tag> restTagFindSave(Tag tag) {
        return ResponseEntity.ok(tagService.save(tag));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tag> restTagUpdate(Tag tag){
        return ResponseEntity.ok(tagService.update(tag));
    }

    @DeleteMapping("/{id}")
    public void restTagDelete(long tagId){
        tagService.delete(tagId);
    }
}
