package ru.kata.money_tracker_service.service;

import ru.kata.money_tracker_service.model.Account;
import ru.kata.money_tracker_service.model.GroupWallets;

import java.util.List;

public interface GroupWalletsService {

    public GroupWallets findById(long groupWalletsId);

    public List<GroupWallets> findAll();

    public boolean save(GroupWallets groupWallets);

    public void update(GroupWallets groupWallets, long id);

    public boolean delete(Long groupWallets);
}
