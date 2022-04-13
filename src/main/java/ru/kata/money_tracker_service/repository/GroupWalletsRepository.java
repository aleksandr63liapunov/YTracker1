package ru.kata.money_tracker_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.money_tracker_service.model.GroupWallets;

@Repository
public interface GroupWalletsRepository extends JpaRepository<GroupWallets, Long> {

}
