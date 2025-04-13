package com.warroom.poker.websocket;

import com.game.GameLogic;
import com.warroom.poker.model.GamePlayer;
import com.warroom.poker.repository.PlayerRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.io.IOException;
import java.util.*;
@Component
public class PokerWebSocketHandler extends TextWebSocketHandler {

    // GameId -> Game instance
    private final Map<String, GameLogic> activeGames = new HashMap<>();

    // PlayerId (UUID string) -> WebSocketSession
    private final Map<UUID, WebSocketSession> playerSessions = new HashMap<>();

    
    private PlayerRepository playerRepository;

    public PokerWebSocketHandler(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        System.out.println("New connection: " + session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        JSONObject json = new JSONObject(message.getPayload());

        String type = json.optString("type", "");
        String gameId = json.optString("gameId", "");
        String rawPlayerId = json.optString("playerId", "");
        UUID playerId;

        try {
            playerId = UUID.fromString(rawPlayerId);
        } catch (IllegalArgumentException e) {
            session.sendMessage(new TextMessage("{\"error\":\"Invalid UUID format\"}"));
            return;
        }

        GamePlayer player = playerRepository.findById(playerId).orElse(null);
        if (player == null) {
            session.sendMessage(new TextMessage("{\"error\":\"Player not found\"}"));
            return;
        }

        GameLogic game = activeGames.get(gameId);

        // Only create the game if the type is START_GAME and it doesn't exist yet
        if ("START_GAME".equals(type) && game == null) {
            int bigBlind = json.optInt("bigBlind", 20);
            int maxPlayers = json.optInt("maxPlayers", 6);

            game = new GameLogic(gameId, player, bigBlind, maxPlayers);
            activeGames.put(gameId, game);
        }

        if (game == null) {
            session.sendMessage(new TextMessage("{\"error\":\"Game not found\"}"));
            return;
        }
        
        

        // Save session
        playerSessions.putIfAbsent(playerId, session);

        switch (type) {
            case "JOIN_GAME":
                game.addPlayer(player);
                broadcast(gameId, "{\"type\": \"JOIN_GAME\", \"player\": \"" + player.getUsername() + "\"}");
                break;

            case "START_GAME":
                game.handleStartGame(player);
                broadcast(gameId, "{\"type\": \"START_GAME\", \"currentPlayer\": \"" + game.getPlayerTurn().getUsername() + "\"}");
                break;

            case "CALL":
                if (!game.isPlayersTurn(playerId)) {
                    sendError(session, "Not your turn.");
                    return;
                }
                game.handleCall(player, game.getCurrentBet());
                broadcast(gameId, "{\"type\": \"CALL\", \"player\": \"" + player.getUsername() + "\"}");
                break;

            case "RAISE":
                if (!game.isPlayersTurn(playerId)) {
                    sendError(session, "Not your turn.");
                    return;
                }
                int amount = json.optInt("amount", 0);
                game.handleRaise(player, amount);
                broadcast(gameId, "{\"type\": \"RAISE\", \"player\": \"" + player.getUsername() + "\", \"amount\": " + amount + "}");
                break;

            case "CHECK":
                if (!game.isPlayersTurn(playerId)) {
                    sendError(session, "Not your turn.");
                    return;
                }
                game.handleCheck(player);
                broadcast(gameId, "{\"type\": \"CHECK\", \"player\": \"" + player.getUsername() + "\"}");
                break;

            case "FOLD":
                if (!game.isPlayersTurn(playerId)) {
                    sendError(session, "Not your turn.");
                    return;
                }
                game.handleFold(player);
                broadcast(gameId, "{\"type\": \"FOLD\", \"player\": \"" + player.getUsername() + "\"}");
                break;

            case "LEAVE":
                game.removePlayer(player);
                playerSessions.remove(playerId);
                broadcast(gameId, "{\"type\": \"LEAVE\", \"player\": \"" + player.getUsername() + "\"}");
                break;

            default:
                sendError(session, "Unknown action: " + type);
        }
    }

    private void sendError(WebSocketSession session, String error) throws IOException {
        session.sendMessage(new TextMessage("{\"error\":\"" + error + "\"}"));
    }

    private void broadcast(String gameId, String message) throws IOException {
        GameLogic game = activeGames.get(gameId);
        if (game == null) return;

        for (GamePlayer player : game.getPlayers()) {
            WebSocketSession session = playerSessions.get(player.getPlayerId());
            if (session != null && session.isOpen()) {
                session.sendMessage(new TextMessage(message));
            }
        }
    }
}
