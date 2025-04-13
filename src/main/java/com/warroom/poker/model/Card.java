package com.warroom.poker.model;

import java.util.Comparator;
import jakarta.persistence.Embeddable;

@Embeddable
public class Card
{
  private String suit;
  private String value;
  private static final java.util.HashMap<String, Integer> cardValues = new java.util.HashMap<String, Integer>() {{
      put("2", 2);
      put("3", 3);
      put("4", 4);
      put("5", 5);
      put("6", 6);
      put("7", 7);
      put("8", 8);
      put("9", 9);
      put("10", 10);
      put("J", 11);
      put("Q", 12);
      put("K", 13);
      put("A", 14);
  }};

  public Card() {}
  
  public Card(String suit, String value, String cardImagePath)
  {
      this.suit = suit;
      this.value = value;
  }

  public String getSuit()
  {
    return this.suit;
  }

  public String getValue()
  {
    return this.value;

  }

  public int getValueInt()
  {
    return cardValues.getOrDefault(this.value,0);
  }

  @Override
  public String toString(){
    return this.value + this.suit;
        
  }

  public static Card fromString(String cardString) {
        if (cardString == null || cardString.length() != 2) {
            throw new IllegalArgumentException("Invalid card string: " + cardString);
        }

        String value = cardString.substring(0, 1);
        String suit = cardString.substring(1);

        return new Card(suit, value, cardImagePath);
    }

  public static final Comparator<Card> byValue = new Comparator<Card>() {
      public int compare(Card c1, Card c2) {
          return c1.getValueInt() - c2.getValueInt();
      }
  };
}