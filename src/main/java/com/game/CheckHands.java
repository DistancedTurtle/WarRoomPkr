package com.game;

import java.util.ArrayList;
import java.util.Collections;
import com.warroom.poker.model.Card;
import com.warroom.poker.model.GamePlayer;
import com.warroom.poker.model.HandRank;



public class CheckHands {

    //returns a list of lists of values of all of the cards of every player at the table. 
    public static ArrayList<Card> getCards(ArrayList<Card> tableCards, GamePlayer player) {
        ArrayList<Card> playerTableHand = new ArrayList<Card>();
        ArrayList<Card> allCards = new ArrayList<Card>();
        allCards.addAll(player.getHandAsCards()); 
        allCards.addAll(tableCards);
        
        for (int j = 0; j < allCards.size(); j++)
          {
            playerTableHand.add(allCards.get(j));
          }
        return playerTableHand;
      }

    public static ArrayList<ArrayList<Card>> generateCombinations(ArrayList<Card> playerTableHand, int start, ArrayList<Card> current, ArrayList<ArrayList<Card>> result, int k) {
            if (current.size() == k) {
                result.add(new ArrayList<>(current)); // Store a copy of the combination
                return result;
            }

            for (int i = start; i < playerTableHand.size(); i++) {
                current.add(playerTableHand.get(i)); // Choose item
                generateCombinations(playerTableHand, i + 1, current, result, k); // Recur with next index
                current.remove(current.size() - 1); // Backtrack
            }
            return result;
        }



    
    public static Boolean royalFlush(ArrayList<Card> combination)
    {
                Collections.sort(combination, Card.byValue);
                if (combination.get(0).getValueInt() == 10 && 
                    combination.get(1).getValueInt() == 11 && 
                    combination.get(2).getValueInt() == 12 && 
                    combination.get(3).getValueInt() == 13 && 
                    combination.get(4).getValueInt() == 14){
                    if (combination.get(0).getSuit().equals(combination.get(1).getSuit()) && 
                        combination.get(1).getSuit().equals(combination.get(2).getSuit()) && 
                        combination.get(2).getSuit().equals(combination.get(3).getSuit()) && 
                        combination.get(3).getSuit().equals(combination.get(4).getSuit())){
                    return true;
                    
                }
                }
        return false;
    }

    public static Boolean straightFlush(ArrayList<Card> combination){
                Collections.sort(combination, Card.byValue);
                if (combination.get(0).getSuit().equals(combination.get(1).getSuit()) && 
                      combination.get(1).getSuit().equals(combination.get(2).getSuit()) && 
                      combination.get(2).getSuit().equals(combination.get(3).getSuit()) && 
                      combination.get(3).getSuit().equals(combination.get(4).getSuit())){
                    if (combination.get(0).getValueInt() + 1 == combination.get(1).getValueInt() &&
                        combination.get(1).getValueInt() + 1 == combination.get(2).getValueInt() &&
                        combination.get(2).getValueInt() + 1 == combination.get(3).getValueInt() &&
                        combination.get(3).getValueInt() + 1 == combination.get(4).getValueInt()){
                        return true;
                    }
                }
        return false;
    }


    
    public static Boolean fourOfAKind(ArrayList<Card> combination)
    {
            Collections.sort(combination, Card.byValue);
            if ((combination.get(0).getValueInt() == combination.get(1).getValueInt() && 
                 combination.get(1).getValueInt() == combination.get(2).getValueInt() && 
                 combination.get(2).getValueInt() == combination.get(3).getValueInt()) || 
                (combination.get(1).getValueInt() == combination.get(2).getValueInt() && 
                 combination.get(2).getValueInt() == combination.get(3).getValueInt() && 
                 combination.get(3).getValueInt() == combination.get(4).getValueInt()))
            {
                return true;
            }
        return false;
    }

    public static ArrayList<Card> fourOfAKindTieBreaker(ArrayList<Card> combination, ArrayList<Card> bestHand)
        {
            Collections.sort(combination, Card.byValue);
            Collections.sort(bestHand, Card.byValue);
            if (combination.get(2).getValueInt() > bestHand.get(2).getValueInt())
            {
                return combination;
            }
            else if (combination.get(2).getValueInt() < bestHand.get(2).getValueInt())
            {
                return bestHand;
            }
            return bestHand;
        }


    
    public static Boolean fullHouse(ArrayList<Card> combination)
    {
            Collections.sort(combination, Card.byValue);
            if ((combination.get(0).getValueInt() == combination.get(1).getValueInt() && 
                 combination.get(1).getValueInt() == combination.get(2).getValueInt() && 
                 combination.get(3).getValueInt() == combination.get(4).getValueInt()) || 
                (combination.get(0).getValueInt() == combination.get(1).getValueInt() && 
                 combination.get(2).getValueInt() == combination.get(3).getValueInt() && 
                 combination.get(3).getValueInt() == combination.get(4).getValueInt()))
            {
                return true;
            }
        return false;
    }

    public static ArrayList<Card> fullHouseTieBreaker(ArrayList<Card> combination, ArrayList<Card> bestHand)
        {
            Collections.sort(combination, Card.byValue);
            Collections.sort(bestHand, Card.byValue);
            if (combination.get(2).getValueInt() > bestHand.get(2).getValueInt())
            {
                return combination;
            }
            else if (combination.get(2).getValueInt() < bestHand.get(2).getValueInt())
            {
                return bestHand;
            }
            return bestHand;
        }


    
    public static Boolean flush(ArrayList<Card> combination)
    {
            Collections.sort(combination, Card.byValue);
            if (combination.get(0).getSuit().equals(combination.get(1).getSuit()) && 
                combination.get(1).getSuit().equals(combination.get(2).getSuit()) && 
                combination.get(2).getSuit().equals(combination.get(3).getSuit()) && 
                combination.get(3).getSuit().equals(combination.get(4).getSuit())) {
                return true;
            }
        return false;
    }

    


    
    public static Boolean straight(ArrayList<Card> combination) {
            Collections.sort(combination, Card.byValue);
            if (combination.get(0).getValueInt() + 1 == combination.get(1).getValueInt() &&
                combination.get(1).getValueInt() + 1 == combination.get(2).getValueInt() &&
                combination.get(2).getValueInt() + 1 == combination.get(3).getValueInt() &&
                combination.get(3).getValueInt() + 1 == combination.get(4).getValueInt()) {
                return true;
            }
        return false;
    }

    public static ArrayList<Card> straightTieBreaker(ArrayList<Card> combination, ArrayList<Card> bestHand)
    {
        Collections.sort(combination, Card.byValue);
        Collections.sort(bestHand, Card.byValue);
        if (combination.get(0).getValueInt() > bestHand.get(0).getValueInt())
        {
            return combination;
        }
        else if (combination.get(0).getValueInt() < bestHand.get(0).getValueInt())
        {
            return bestHand;
        }
        return bestHand;
    }


    
    public static Boolean threeOfAKind(ArrayList<Card> combination)
    {
            Collections.sort(combination, Card.byValue);
            if ((combination.get(0).getValueInt() == combination.get(1).getValueInt() && 
                 combination.get(1).getValueInt() == combination.get(2).getValueInt()) || 
                (combination.get(1).getValueInt() == combination.get(2).getValueInt() && 
                 combination.get(2).getValueInt() == combination.get(3).getValueInt()) || 
                (combination.get(2).getValueInt() == combination.get(3).getValueInt() && 
                 combination.get(3).getValueInt() == combination.get(4).getValueInt())) {
                return true;
            }
        return false;
    }
    public static ArrayList<Card> threeOfAKindTieBreaker(ArrayList<Card> combination, ArrayList<Card> bestHand)
    {
        for (int i=0; i<3; i++)
        {
            if (combination.get(i).getValueInt() == combination.get(i+1).getValueInt()&&
                combination.get(i).getValueInt() == combination.get(i+2).getValueInt())
                {
                    Card pairValue = combination.get(i);
                    combination.remove(i);
                    combination.remove(i);
                    combination.remove(i);
                    Collections.sort(combination, Card.byValue);
                    combination.add(0,pairValue);
                    combination.add(0,pairValue);
                    combination.add(0,pairValue);
                }
            if (bestHand.get(i).getValueInt() == bestHand.get(i+1).getValueInt()&&
                bestHand.get(i).getValueInt() == bestHand.get(i+2).getValueInt())
            {
                Card pairValue = bestHand.get(i);
                bestHand.remove(i);
                bestHand.remove(i);
                bestHand.remove(i);
                Collections.sort(bestHand, Card.byValue);
                bestHand.add(0,pairValue);
                bestHand.add(0,pairValue);
                bestHand.add(0,pairValue);
            }
        }
        if (bestHand.get(0).getValueInt()>combination.get(0).getValueInt())
        {
            return bestHand;
        }
        else if (bestHand.get(0).getValueInt()<combination.get(0).getValueInt())
        {
            return combination;
        }
        else
        {
            for (int j=3;j<5;j++)
            {
                if (bestHand.get(j).getValueInt()>combination.get(j).getValueInt())
                {
                    return bestHand;
                }
                else if (bestHand.get(j).getValueInt()<combination.get(j).getValueInt())
                {
                    return combination;
                }
            }
            return bestHand;
        }
    }


    public static Boolean twoPair(ArrayList<Card> combination)
    { 
        Collections.sort(combination, Card.byValue);
        if ((combination.get(0).getValueInt() == combination.get(1).getValueInt() && 
             combination.get(2).getValueInt() == combination.get(3).getValueInt()) || 
            (combination.get(0).getValueInt() == combination.get(1).getValueInt() && 
             combination.get(3).getValueInt() == combination.get(4).getValueInt()) || 
            (combination.get(1).getValueInt() == combination.get(2).getValueInt() && 
             combination.get(3).getValueInt() == combination.get(4).getValueInt())) {
            return true;
        }
        return false;
    }

    public static ArrayList<Card> twoPairTieBreaker(ArrayList<Card> combination, ArrayList<Card> bestHand){

        Collections.sort(combination, Card.byValue);
        Collections.sort(bestHand, Card.byValue);
        int bestKicker = 0;
        int combKicker = 0;
        //for combination kicker
        if (combination.get(0).getValueInt() != combination.get(1).getValueInt()){
            combKicker = combination.get(0).getValueInt();
        }
        else if (combination.get(4).getValueInt() != combination.get(3).getValueInt()){
            combKicker = combination.get(4).getValueInt();
        }
        else{
            combKicker = combination.get(2).getValueInt();
        //for best hand kicker
        } 
        if (bestHand.get(0).getValueInt() != bestHand.get(1).getValueInt()){
            bestKicker = bestHand.get(0).getValueInt();
        }
        else if (bestHand.get(4).getValueInt() != bestHand.get(3).getValueInt()){
            bestKicker = bestHand.get(4).getValueInt();
        }
        else{
            bestKicker = bestHand.get(2).getValueInt();
        }
        
        if (combination.get(1).getValueInt() > bestHand.get(1).getValueInt()) {
            return(combination);
        }
        else if (combination.get(1).getValueInt() == bestHand.get(1).getValueInt()){
            if (combination.get(3).getValueInt() > bestHand.get(3).getValueInt()){
                return(combination);
            }
            else if (combination.get(3).getValueInt() == bestHand.get(3).getValueInt()){
                if (combKicker > bestKicker){
                    return(combination);
                }
                return(bestHand);
            }
            else{
                return(bestHand);
            }
        }
        else{
            return(bestHand);
        }
    }

    public static Boolean onePair(ArrayList<Card> combination)
    {
        Collections.sort(combination, Card.byValue);
        if (combination.get(0).getValueInt() == combination.get(1).getValueInt() || 
            combination.get(1).getValueInt() == combination.get(2).getValueInt() || 
            combination.get(2).getValueInt() == combination.get(3).getValueInt() || 
            combination.get(3).getValueInt() == combination.get(4).getValueInt()) {
            return true;
        }
        return false;
    }
   
    
    
    
    
    
    
    
    public static ArrayList<Card> onePairTieBreaker(ArrayList<Card> combination, ArrayList<Card> bestHand)
        {
            Collections.sort(combination, Card.byValue);
            Collections.sort(bestHand, Card.byValue);
            for (int i=0 ; i<4; i++){
                if (combination.get(i).getValueInt() == combination.get(i+1).getValueInt())
                    {
                        Card pairValue = combination.get(i);
                        combination.remove(i);
                        combination.remove(i);
                        Collections.sort(combination, Card.byValue);
                        combination.add(0,pairValue);
                        combination.add(0,pairValue);
                    }
                if (bestHand.get(i).getValueInt() == bestHand.get(i+1).getValueInt())
                {
                    Card pairValue = bestHand.get(i);
                    bestHand.remove(i);
                    bestHand.remove(i);
                    Collections.sort(bestHand, Card.byValue);
                    bestHand.add(0,pairValue);
                    bestHand.add(0,pairValue);
                }
            }
                
            if (bestHand.get(0).getValueInt()>combination.get(0).getValueInt())
            {
                return bestHand;
            }
            else if (bestHand.get(0).getValueInt()<combination.get(0).getValueInt())
            {
                return combination;
            }
            else
            {
                for (int j=2;j<5;j++)
                    {
                        if (bestHand.get(j).getValueInt()>combination.get(j).getValueInt())
                        {
                            return bestHand;
                        }
                        else if (bestHand.get(j).getValueInt()<combination.get(j).getValueInt())
                        {
                            return combination;
                        }
                    }
            }
            return bestHand; 
            
        }
    
    public static ArrayList<Card> highCardTieBreaker(ArrayList<Card> combination, ArrayList<Card> bestHand)
    {
        Collections.sort(combination, Card.byValue);
        Collections.sort(bestHand, Card.byValue);
        for (int i = 0; i < 5; i++){
            if (combination.get(i).getValueInt() > bestHand.get(i).getValueInt())
            {
                return combination;
            }
            else if (combination.get(i).getValueInt() < bestHand.get(i).getValueInt())
            {
                return(bestHand);
            }
        }
        return bestHand;
    }

    //simmilar to old function, but does not set ranks, it just returns the handrank of a specific combination, this is useful because we can use those to compare multiple combinations that a single player has(function for that is below the evaluateHand func.).
    public static HandRank evaluateHand(ArrayList<Card> combination){
            if (royalFlush(combination))
            {
                return HandRank.ROYAL_FLUSH;
            }
            else if (straightFlush(combination))
            {
                return HandRank.STRAIGHT_FLUSH;
            }
            else if (fourOfAKind(combination))
            {
                return HandRank.FOUR_OF_A_KIND;
            }
            else if (fullHouse(combination))
            {
                return HandRank.FULL_HOUSE;
            }
            else if (flush(combination))
            {
                return HandRank.FLUSH;
            }
            else if (straight(combination))
            {
                return HandRank.STRAIGHT;
            }
            else if (threeOfAKind(combination))
            {
                return HandRank.THREE_OF_A_KIND;
            }
            else if (twoPair(combination))
            {
                return HandRank.TWO_PAIR;
            }
            else if (onePair(combination))
            {
                return HandRank.ONE_PAIR;
            }
            else
            {
                return HandRank.HIGH_CARD;
            }
    }

    
    public static void findBestHand(ArrayList<ArrayList<Card>> combinations, GamePlayer player, ArrayList<Card> playerTableHand){

        ArrayList<Card> bestHand = null;
        
            for (ArrayList<Card> combination : combinations)
            {
                if (bestHand == null || evaluateHand(combination).ordinal() > evaluateHand(bestHand).ordinal()){
                    bestHand = combination;
                }
                else if (evaluateHand(combination).ordinal() == evaluateHand(bestHand).ordinal())
                    if (evaluateHand(bestHand) == HandRank.HIGH_CARD)
                    {
                        bestHand = highCardTieBreaker(combination, bestHand);     
                    }
                    else if (evaluateHand(bestHand) == HandRank.ONE_PAIR)
                    {
                        bestHand = onePairTieBreaker(combination, bestHand);
                    }
                    else if (evaluateHand(bestHand) == HandRank.TWO_PAIR)
                    {
                    
                    }
                    else if (evaluateHand(bestHand) == HandRank.THREE_OF_A_KIND)
                    {
                        bestHand = threeOfAKindTieBreaker(combination, bestHand);
                    }
                    else if (evaluateHand(bestHand) == HandRank.STRAIGHT)
                    {
                        bestHand = straightTieBreaker(combination, bestHand);
                    }
                    else if (evaluateHand(bestHand) == HandRank.FLUSH)
                    {
                        bestHand = highCardTieBreaker(combination, bestHand);
                    }
                    else if (evaluateHand(bestHand) == HandRank.FULL_HOUSE)
                    {
                        bestHand = fullHouseTieBreaker(combination, bestHand);
                    }
                    else if (evaluateHand(bestHand) == HandRank.FOUR_OF_A_KIND)
                    {
                        bestHand = fullHouseTieBreaker(combination, bestHand);
                    }
                    else if (evaluateHand(bestHand) == HandRank.STRAIGHT_FLUSH)
                    {
                        bestHand = highCardTieBreaker(combination, bestHand);
                    }
            player.setHandRank(evaluateHand(bestHand));
            player.setBestHand(bestHand);
    }
    }
    /*public static player checkWinner(ArrayList<player> players)
    {
        if (players == null || players.isEmpty()) {
            return null; // No players
        }

        player bestPlayer = players.get(0);
        for (int i = 1; i < players.size(); i++) {
            player current = players.get(i);

            // Compare hand ranks
            if (current.getHandRank().ordinal() > bestPlayer.getHandRank().ordinal()) {
                bestPlayer = current;
            } else if (current.getHandRank().ordinal() == bestPlayer.getHandRank().ordinal()) {
                // Use tie-breaking function
                ArrayList<Card> betterHand = tieBreaker(bestPlayer.getBestHand, current.bestHand);
                if (betterHand.equals(current.bestHand)) {
                    bestPlayer = current;
                }
            }
        }
        return bestPlayer;
    }*/
}


