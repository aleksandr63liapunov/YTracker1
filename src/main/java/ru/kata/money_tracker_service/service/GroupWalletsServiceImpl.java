package ru.kata.money_tracker_service.service;

import org.springframework.stereotype.Service;
import ru.kata.money_tracker_service.model.GroupWallets;
import ru.kata.money_tracker_service.repository.GroupWalletsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GroupWalletsServiceImpl implements GroupWalletsService{

    private final GroupWalletsRepository groupWalletsRepository;

    public GroupWalletsServiceImpl(GroupWalletsRepository groupWalletsRepository) {
        this.groupWalletsRepository = groupWalletsRepository;
    }

    @Override
    public Optional<GroupWallets> findById(long groupWalletsId) {
        return groupWalletsRepository.findById(groupWalletsId);
    }

    @Override
    public List<GroupWallets> findAll() {
        return groupWalletsRepository.findAll();
    }

    @Override
    public GroupWallets save(GroupWallets groupWallets) {

        return groupWalletsRepository.save(groupWallets);
    }

    @Override
    public GroupWallets update(GroupWallets groupWallets) {

        return groupWalletsRepository.save(groupWallets);
    }

    @Override
    public void delete(Long groupWalletsId) {

        groupWalletsRepository.delete(groupWalletsRepository.findById(groupWalletsId).get());
    }

    public void deleteAll() {
        groupWalletsRepository.deleteAll();
    }
}
