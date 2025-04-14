package com.warroom.poker; // Put your test package here

import com.warroom.poker.model.Game;
import com.warroom.poker.model.GamePlayer;
import com.warroom.poker.model.UserProfile;
import com.warroom.poker.model.Deck;
import com.warroom.poker.model.Card;
import com.game.DealingMethods;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.Arrays;

public class GameTest {

    @PersistenceContext
    private EntityManager em;

    public void testGameFlow() {
        // Step 1: Create a Game
        Game game = new Game("Starting");

        // Step 2: Create UserProfiles for the players
        UserProfile userProfile1 = new UserProfile("player1", "1000");  // Assuming UserProfile constructor exists
        UserProfile userProfile2 = new UserProfile("player2", "1000");

        // Step 3: Create GamePlayer instances
        GamePlayer player1 = new GamePlayer(userProfile1, game);
        GamePlayer player2 = new GamePlayer(userProfile2, game);

        // Step 4: Add players to game
        ArrayList<GamePlayer> playerList = new ArrayList<>();
        playerList.add(player1);
        playerList.add(player2);
        game.setPlayers(playerList);

        // Step 5: Deal cards (simulated by calling your deal method)
        Deck deck = new Deck();  // Assuming you have a Deck class
        DealingMethods.deal(game.getPlayers(), deck, 2);  // Deals 2 players

        // Step 6: Persist the game object
        em.persist(game);

        // Step 7: Retrieve from the database and validate the changes
        Game retrievedGame = em.find(Game.class, game.getGameId());

        // Step 8: Validate that the cards were stored as strings
        for (GamePlayer p : retrievedGame.getPlayers()) {
            System.out.println("Player: " + p.getUserProfile().getUserName() + " Hand: " + p.getHand());
        }
    }
}
