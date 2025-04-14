package com.warroom.poker.model;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

public class Deck
{
  private ArrayList<Card> deck;
  Card C2S = new Card("Spades", "2", "2S.png");
  Card C3S = new Card("Spades", "3", "3S.png");
  Card C4S = new Card("Spades", "4", "4S.png");
  Card C5S = new Card("Spades", "5", "5S.png");
  Card C6S = new Card("Spades", "6", "6S.png");
  Card C7S = new Card("Spades", "7", "7S.png");
  Card C8S = new Card("Spades", "8", "8S.png");
  Card C9S = new Card("Spades", "9", "9S.png");
  Card C10S = new Card("Spades", "10", "10S.png");
  Card CJS = new Card("Spades", "J", "JS.png");
  Card CQS = new Card("Spades", "Q", "QS.png");
  Card CKS = new Card("Spades", "K", "KS.png");
  Card CAS = new Card("Spades", "A", "AS.png");
  Card C2H = new Card("Hearts", "2", "2H.png");
  Card C3H = new Card("Hearts", "3", "3H.png");
  Card C4H = new Card("Hearts", "4", "4H.png");
  Card C5H = new Card("Hearts", "5", "5H.png");
  Card C6H = new Card("Hearts", "6", "6H.png");
  Card C7H = new Card("Hearts", "7", "7H.png");
  Card C8H = new Card("Hearts", "8", "8H.png");
  Card C9H = new Card("Hearts", "9", "9H.png");
  Card C10H = new Card("Hearts", "10", "10H.png");
  Card CJH = new Card("Hearts", "J", "JH.png");
  Card CQH = new Card("Hearts", "Q", "QH.png");
  Card CKH = new Card("Hearts", "K", "KH.png");
  Card CAH = new Card("Hearts", "A", "AH.png");
  Card C2C = new Card("Clubs", "2", "2C.png");
  Card C3C = new Card("Clubs", "3", "3C.png");
  Card C4C = new Card("Clubs", "4", "4C.png");
  Card C5C = new Card("Clubs", "5", "5C.png");
  Card C6C = new Card("Clubs", "6", "6C.png");
  Card C7C = new Card("Clubs", "7", "7C.png");
  Card C8C = new Card("Clubs", "8", "8C.png");
  Card C9C = new Card("Clubs", "9", "9C.png");
  Card C10C = new Card("Clubs", "10", "10C.png");
  Card CJC = new Card("Clubs", "J", "JC.png");
  Card CQC = new Card("Clubs", "Q", "QC.png");
  Card CKC = new Card("Clubs", "K", "KC.png");
  Card CAC = new Card("Clubs", "A", "AC.png");
  Card C2D = new Card("Diamonds", "2", "2D.png");
  Card C3D = new Card("Diamonds", "3", "3D.png");
  Card C4D = new Card("Diamonds", "4", "4D.png");
  Card C5D = new Card("Diamonds", "5", "5D.png");
  Card C6D = new Card("Diamonds", "6", "6D.png");
  Card C7D = new Card("Diamonds", "7", "7D.png");
  Card C8D = new Card("Diamonds", "8", "8D.png");
  Card C9D = new Card("Diamonds", "9", "9D.png");
  Card C10D = new Card("Diamonds", "10", "10D.png");
  Card CJD = new Card("Diamonds", "J", "JD.png");
  Card CQD = new Card("Diamonds", "Q", "QD.png");
  Card CKD = new Card("Diamonds", "K", "KD.png");
  Card CAD = new Card("Diamonds", "A", "AD.png");

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
