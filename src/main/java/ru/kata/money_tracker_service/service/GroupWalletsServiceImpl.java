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

        GroupWallets groupWalletsFromDB = groupWalletsRepository
                .findById(groupWallets.getId()).orElse(null); //?

        if (groupWalletsFromDB != null) {
            return groupWalletsFromDB;
        }
        groupWalletsRepository.save(groupWallets);
        return groupWallets;
    }

    @Override
    public GroupWallets update(GroupWallets groupWallets, long id) {

        groupWallets.setId(id);
        groupWalletsRepository.save(groupWallets);
        return groupWallets;
    }

    @Override
    public void delete(Long groupWalletsId) {

        if (groupWalletsRepository.findById(groupWalletsId).isPresent()) {
            groupWalletsRepository.deleteById(groupWalletsId);
        } else {
            groupWalletsRepository.delete(groupWalletsRepository.findById(groupWalletsId).get());
        }
    }

    public void deleteAll() {
        groupWalletsRepository.deleteAll();
    }
}
