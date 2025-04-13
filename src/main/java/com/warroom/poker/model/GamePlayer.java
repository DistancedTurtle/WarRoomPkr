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
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="players")
public class GamePlayer
  {
    @Id
    @Column(name = "player_id")
    private UUID playerId;
    @ElementCollection
    private ArrayList<String> handStrings;
    @Transient
    private UserProfile userProfile;
    private int chips;
    private HandRank handRank;
    @Transient
    private ArrayList<Card> bestHand;
    private int currentBet;
    private String userName;
    
    public GamePlayer(UserProfile userProfile)
    {
      this.handStrings = new ArrayList<String>();
      this.handRank = HandRank.HIGH_CARD;
      this.currentBet = 0;
      this.playerId = userProfile.getPlayerId();
      this.userName = userProfile.getUserName();
      this.chips = userProfile.getChips();
    }
    public void addCard(String card)
    {
      handStrings.add(card);
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

      return(this.bestHand);
      
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
      return playerId;
    }
    
    public void setChips(int chips){
      this.chips = chips;
    }
    
    public int getChips(){ 
      return chips; 
    }

  }