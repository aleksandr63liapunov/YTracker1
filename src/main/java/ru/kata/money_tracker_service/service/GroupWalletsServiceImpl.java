package ru.kata.money_tracker_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.money_tracker_service.model.Account;
import ru.kata.money_tracker_service.model.GroupWallets;
import ru.kata.money_tracker_service.model.Wallet;
import ru.kata.money_tracker_service.repository.GroupWalletsRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
public class GroupWalletsServiceImpl implements GroupWalletsService{

    @PersistenceContext
    private EntityManager em;

    final GroupWalletsRepository groupWalletsRepository;

    @Autowired
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
    public boolean save(GroupWallets groupWallets) {

        GroupWallets groupWalletsFromDB = groupWalletsRepository
                .findById(groupWallets.getId()).orElse(null); //?

        if (groupWalletsFromDB != null) {
            return false;
        }
        groupWalletsRepository.save(groupWallets);
        return true;
    }

    @Override
    public void update(GroupWallets groupWallets, long id) {

        groupWallets.setId(id);
        groupWalletsRepository.save(groupWallets);
    }

    @Override
    public boolean delete(Long groupWalletsId) {

        if (groupWalletsRepository.findById(groupWalletsId).isPresent()) {
            groupWalletsRepository.deleteById(groupWalletsId);
            return true;
        }
        return false;
    }
}
