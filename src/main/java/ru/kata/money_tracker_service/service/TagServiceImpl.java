package ru.kata.money_tracker_service.service;

import org.springframework.stereotype.Service;
import ru.kata.money_tracker_service.model.Tag;
import ru.kata.money_tracker_service.repository.TagRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository repository;

    public TagServiceImpl(TagRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Tag> findById(long tagId) {
        return repository.findById(tagId);
    }

    @Override
    public List<Tag> findAll() {
        return repository.findAll();
    }

    @Override
    public Tag save(Tag tag) {
        return repository.save(tag);
    }

    @Override
    public Tag update(Tag tag) {
        return repository.save(tag);
    }

    @Override
    public void delete(Long tagId) {
        repository.deleteById(tagId);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
