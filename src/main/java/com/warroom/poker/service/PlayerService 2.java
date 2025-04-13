package com.warroom.poker.service;


import com.warroom.poker.model.GamePlayer;
import com.warroom.poker.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

public class PlayerService {
    private PlayerRepository playerRepo;

    public GamePlayer register(String username, String password)
    {
        GamePlayer p = new GamePlayer(username, password);
        return playerRepo.save(p);
    }

    public Optional<GamePlayer> login(String username, String password) 
    {
        return playerRepo.findByUsername(username)
                .filter(p -> p.getPassword().equals(password)); // 🔐 hash check in real world
    }
}
