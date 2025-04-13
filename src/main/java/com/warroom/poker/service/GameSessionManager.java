package com.warroom.poker.service;
import com.game.GameLogic;
import java.util.*;
import com.warroom.poker.model.GamePlayer;

public class GameSessionManager {

    // Store all active games (gameId -> Game instance)
    private static final Map<String, GameLogic> activeGames = new HashMap<>();

    // Create a new game with settings
    public static String createGame(GamePlayer hostPlayer, int bigBlind, int maxPlayers) {
        String gameId = UUID.randomUUID().toString(); // Generate unique ID
        GameLogic newGame = new GameLogic(gameId, hostPlayer, bigBlind, maxPlayers);
        activeGames.put(gameId, newGame);
        return gameId;
    }

    // Join an existing game
    public static boolean joinGame(GamePlayer joiningPlayer, String playerId, String gameId) {
        GameLogic game = activeGames.get(gameId);
        if (game != null) {
            return game.addPlayer(joiningPlayer);
        }
        return false; // Game not found
    }

    // Get game by ID
    public static GameLogic getGame(String gameId) {
        return activeGames.get(gameId);
    }

    // Remove game if it ends
    public static void removeGame(String gameId) {
        activeGames.remove(gameId);
    }
}
