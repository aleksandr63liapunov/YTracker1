package ru.kata.money_tracker_service.service;

import ru.kata.money_tracker_service.model.Account;
import ru.kata.money_tracker_service.model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {

    Optional<Tag> findById(long tagId);

    List<Tag> findAll();

    Tag save(Tag tag);

    Tag update(Tag tag);

    void delete(Long tagId);

    void deleteAll();
}
