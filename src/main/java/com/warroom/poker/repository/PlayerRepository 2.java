package com.warroom.poker.repository;


import com.warroom.poker.model.GamePlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.UUID;


public interface PlayerRepository extends JpaRepository<GamePlayer, UUID>{
    Optional<GamePlayer> findByUsername(String username);
}
