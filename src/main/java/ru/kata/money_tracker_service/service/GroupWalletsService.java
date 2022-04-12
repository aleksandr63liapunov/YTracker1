package ru.kata.money_tracker_service.service;

import ru.kata.money_tracker_service.model.GroupWallets;

import java.util.List;
import java.util.Optional;

public interface GroupWalletsService {

    Optional<GroupWallets> findById(long groupWalletsId);

    List<GroupWallets> findAll();

    GroupWallets save(GroupWallets groupWallets);

    GroupWallets update(GroupWallets groupWallets);

    void delete(Long groupWallets);

    void deleteAll();
}
