package com.warroom.poker.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;

@Entity
public class Game {

    @Id
    @GeneratedValue
    private UUID gameId;

    private String gameState;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private ArrayList<GamePlayer> players;

    // Getters and Setters
    public UUID getGameId() {
        return gameId;
    }

    public String getGameState() {
        return gameState;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }

    public ArrayList<GamePlayer> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<GamePlayer> players) {
        this.players = players;
    }

    // Optional constructor
    public Game(String gameState) {
        this.gameState = gameState;
    }

    public Game() {
        // Default constructor for JPA
    }
}