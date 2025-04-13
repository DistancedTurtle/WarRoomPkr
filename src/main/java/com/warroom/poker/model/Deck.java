package com.warroom.poker.model;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

public class Deck
{
  private ArrayList<Card> deck;
  Card C2S = new Card("Spades", "2", "spades_2.png");
  Card C3S = new Card("Spades", "3", "spades_3.png");
  Card C4S = new Card("Spades", "4", "spades_4.png");
  Card C5S = new Card("Spades", "5", "spades_5.png");
  Card C6S = new Card("Spades", "6", "spades_6.png");
  Card C7S = new Card("Spades", "7", "spades_7.png");
  Card C8S = new Card("Spades", "8", "spades_8.png");
  Card C9S = new Card("Spades", "9", "spades_9.png");
  Card C10S = new Card("Spades", "10", "spades_10.png");
  Card CJS = new Card("Spades", "J", "spades_J.png");
  Card CQS = new Card("Spades", "Q", "spades_Q.png");
  Card CKS = new Card("Spades", "K", "spades_K.png");
  Card CAS = new Card("Spades", "A", "spades_A.png");
  Card C2H = new Card("Hearts", "2", "hearts_2.png");
  Card C3H = new Card("Hearts", "3", "hearts_3.png");
  Card C4H = new Card("Hearts", "4", "hearts_4.png");
  Card C5H = new Card("Hearts", "5", "hearts_5.png");
  Card C6H = new Card("Hearts", "6", "hearts_6.png");
  Card C7H = new Card("Hearts", "7", "hearts_7.png");
  Card C8H = new Card("Hearts", "8", "hearts_8.png");
  Card C9H = new Card("Hearts", "9", "hearts_9.png");
  Card C10H = new Card("Hearts", "10", "hearts_10.png");
  Card CJH = new Card("Hearts", "J", "hearts_J.png");
  Card CQH = new Card("Hearts", "Q", "hearts_Q.png");
  Card CKH = new Card("Hearts", "K", "hearts_K.png");
  Card CAH = new Card("Hearts", "A", "hearts_A.png");
  Card C2C = new Card("Clubs", "2", "clubs_2.png");
  Card C3C = new Card("Clubs", "3", "clubs_3.png");
  Card C4C = new Card("Clubs", "4", "clubs_4.png");
  Card C5C = new Card("Clubs", "5", "clubs_5.png");
  Card C6C = new Card("Clubs", "6", "clubs_6.png");
  Card C7C = new Card("Clubs", "7", "clubs_7.png");
  Card C8C = new Card("Clubs", "8", "clubs_8.png");
  Card C9C = new Card("Clubs", "9", "clubs_9.png");
  Card C10C = new Card("Clubs", "10", "clubs_10.png");
  Card CJC = new Card("Clubs", "J", "clubs_J.png");
  Card CQC = new Card("Clubs", "Q", "clubs_Q.png");
  Card CKC = new Card("Clubs", "K", "clubs_K.png");
  Card CAC = new Card("Clubs", "A", "clubs_A.png");
  Card C2D = new Card("Diamonds", "2", "diamonds_2.png");
  Card C3D = new Card("Diamonds", "3", "diamonds_3.png");
  Card C4D = new Card("Diamonds", "4", "diamonds_4.png");
  Card C5D = new Card("Diamonds", "5", "diamonds_5.png");
  Card C6D = new Card("Diamonds", "6", "diamonds_6.png");
  Card C7D = new Card("Diamonds", "7", "diamonds_7.png");
  Card C8D = new Card("Diamonds", "8", "diamonds_8.png");
  Card C9D = new Card("Diamonds", "9", "diamonds_9.png");
  Card C10D = new Card("Diamonds", "10", "diamonds_10.png");
  Card CJD = new Card("Diamonds", "J", "diamonds_J.png");
  Card CQD = new Card("Diamonds", "Q", "diamonds_Q.png");
  Card CKD = new Card("Diamonds", "K", "diamonds_K.png");
  Card CAD = new Card("Diamonds", "A", "diamonds_A.png");

  public Deck()
  {
    deck = new ArrayList<Card>(Arrays.asList(C2S,C3S,C4S,C5S,C6S,C7S,C8S,C9S,C10S,CJS,CQS,CKS,CAS,
      C2H,C3H,C4H,C5H,C6H,C7H,C8H,C9H,C10H,CJH,CQH,CKH,CAH,
      C2D,C3D,C4D,C5D,C6D,C7D,C8D,C9D,C10D,CJD,CQD,CKD,CAD,
      C2C,C3C,C4C,C5C,C6C,C7C,C8C,C9C,C10C,CJC,CQC,CKC,CAC));
  }
  

  public ArrayList<Card> getDeck(){
  
    return deck;
  }
  
  public void shuffle()
  {
    Collections.shuffle(deck);
  }
}
