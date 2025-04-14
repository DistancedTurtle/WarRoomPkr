package com.warroom.poker.model;
import java.util.Comparator;
import java.util.ArrayList; 
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="players")
public class GamePlayer
  {

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ElementCollection
    private ArrayList<String> handStrings;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private UserProfile userProfile;

    private HandRank handRank;
    @Transient
    private ArrayList<Card> bestHand;

    private int currentBet;
    
    public GamePlayer(UserProfile userProfile, Game game)
    {
      this.handStrings = new ArrayList<>();
      this.handRank = HandRank.HIGH_CARD;
      this.currentBet = 0;
      this.userProfile = userProfile;
      this.game = game;
    }
    public void addCard(String card)
    {
      handStrings.add(card);
    }

    public ArrayList<Card> getHandAsCards(){
      ArrayList<Card> cardObjects = new ArrayList<>();
        for (String cardString : handStrings) {
            cardObjects.add(Card.fromString(cardString));
        }
        return cardObjects;
    }

    public ArrayList<String> getHand()
    {
      return handStrings;
    }
    public HandRank getHandRank()
    {
      return handRank;
    }
    public void setHandRank(HandRank handRank)
    {
      this.handRank = handRank;
    }
    
    public UserProfile getUserProfile()
    {
      return userProfile;
    }
    public void setBestHand(ArrayList<Card> bestHand)
    {
      this.bestHand = bestHand;
    }
    
    public ArrayList<Card> getBestHand(){

      return this.bestHand;
      
    }
    public static final Comparator<GamePlayer> byHandRank = new Comparator<GamePlayer>() {
      public int compare(GamePlayer p1, GamePlayer p2) {
          return p1.getHandRank().ordinal() - p2.getHandRank().ordinal();
      }
    };
    public int getCurrentBet()
    {
      return currentBet;
    }
    public void setCurrentBet(int x)
    {
      currentBet+=x;
    }
    public UUID getPlayerId()
    {
      return userProfile.getPlayerId();
    }
    
    public int getChips(){ 
      return userProfile.getChips(); 
    }

    public void setGame(Game game) {
      this.game = game;
    }

    public Game getGame() {
      return game;
    }

  }