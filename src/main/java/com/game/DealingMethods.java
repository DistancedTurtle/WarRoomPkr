package com.game;

import java.util.ArrayList;
import com.warroom.poker.model.Card;
import com.warroom.poker.model.GamePlayer;
import com.warroom.poker.model.Deck;


public class DealingMethods
  {
 
    public static void deal(ArrayList<GamePlayer> players, Deck deck, int numPlayers)
    {
      //possibly reset cards here with new reset cards function in the player class like: player.resetCards();
      for(int i = 0; i < numPlayers; i++)
        {
          for(int j = 0; j < 2; j++)
            {
              players.get(i).addCard(deck.getDeck().get(0).toString());
              deck.getDeck().remove(0);
            }
        }
    }

    
    public static ArrayList<Card> flop(Deck deck, ArrayList<Card> tableCards)
    {
      for(int i = 0; i < 3; i++)
        {
          tableCards.add(deck.getDeck().get(0));
          deck.getDeck().remove(0);
        }
      return tableCards;
    }
    

    public static ArrayList<Card> turn(Deck deck, ArrayList<Card> tableCards)
    {
      tableCards.add(deck.getDeck().get(0));
      deck.getDeck().remove(0);
      return tableCards;
    }

    public static ArrayList<Card> river(Deck deck, ArrayList<Card> tableCards){

      tableCards.add(deck.getDeck().get(0));
      deck.getDeck().remove(0);
      return tableCards;
      
    }
  }