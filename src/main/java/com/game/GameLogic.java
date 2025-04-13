package com.game;
import java.util.ArrayList;
import java.util.Scanner;
import com.warroom.poker.model.Card;
import com.warroom.poker.model.Deck;
import org.springframework.security.access.method.P;
import java.util.UUID;
import com.warroom.poker.model.GamePlayer;

public class GameLogic
{
    private String gameId;
    private GamePlayer hostPlayer;
    private int bigBlind;
    private int maxPlayers;
    private ArrayList<GamePlayer> players;
    private ArrayList<GamePlayer> playersIn;
    ArrayList<GamePlayer> playerList = new ArrayList<GamePlayer>();
    int roundCount = 0;
    Scanner sc = new Scanner(System.in);
    private int currentBet;
    private int pot;
    private int currentPlayerIndex;
    private Deck deck;
    private int roundNumber;
    private ArrayList<Card> tableCards;
    private GamePlayer playerTurn;

    public GameLogic(String gameId, GamePlayer hostPlayer, int bigBlind, int maxPlayers) {
        this.gameId = gameId;
        this.hostPlayer = hostPlayer;
        this.bigBlind = bigBlind;
        this.maxPlayers = maxPlayers;
        this.players = new ArrayList<>();
        this.playersIn = new ArrayList<>();
        this.players.add(hostPlayer); // Add host automatically
        this.pot = 0;
        this.currentBet =0;
        this.currentPlayerIndex = 0;
        this.roundNumber=0;
        tableCards = new ArrayList<>();
        this.deck = new Deck();
        this.playerTurn=hostPlayer;

    }

    public boolean addPlayer(GamePlayer playerId) {
        if (players.size() < maxPlayers) {
            players.add(playerId);
            return true;
        }
        return false; // Game is full
    }

    public ArrayList<GamePlayer> getPlayers() {
        return players;
    }
    
    public void nextTurn()
    {
       if(currentPlayerIndex<players.size()-1)
       {
            currentPlayerIndex++;
            playerTurn = players.get(currentPlayerIndex);
       }
       else if (playersIn.size()==players.size())
       {
        roundNumber++;
        currentPlayerIndex=0;
        nextRound();
       }
       
        
    }
    public GamePlayer getPlayerTurn()
    {
        return playerTurn;
    }

    public boolean isPlayersTurn(UUID playerId)
    {
        if(playerId.equals(playerTurn.getPlayerId()))
        {
            return true;
        }
        return false;
        
        
    }

    public int getCurrentBet()
    {
        return currentBet;
    }


    public void handleStartGame(GamePlayer player)
    {
        if (player == hostPlayer)
        {
            GameMethods.deal(players,deck,players.size());
        }
    }

    public void handleCall(GamePlayer player, int currentBet)
    {
        player.setCurrentBet(currentBet-player.getCurrentBet());
        pot+=currentBet-player.getCurrentBet();
        nextTurn();
    }
    public void handleCheck(GamePlayer player)
    {
        nextTurn();
    }
    public void handleFold(GamePlayer player)
    {
       if (player!= null)
       {
        players.remove(currentPlayerIndex);
        nextTurn();
       }   
    }
    public void handleRaise(GamePlayer player, int raise)
    {
        pot += raise - player.getCurrentBet();
        player.setCurrentBet(raise);
        nextTurn();
        playersIn.clear();
        playersIn.add(player);
    }

    public void removePlayer(GamePlayer player)
    {
        players.remove(player);
    }
    




    public void nextRound()
    {
        if (roundNumber==0)
        {
            GameMethods.deal(players,deck,players.size());
        }
        else if (roundNumber==1)
        {
            GameMethods.flop(deck,tableCards);
        }
        else if (roundNumber==2)
        {
            GameMethods.turn(deck,tableCards);
        }
        else if (roundNumber==3)
        {
            GameMethods.river(deck,tableCards);
        }
        else
        {

        }
    }

    
    public void doGame()
    {
        
    }
    /*public static Boolean nextRound(ArrayList<player> playerList, ArrayList<player> playersIn)
    {
        if (playerList.size() == playersIn.size())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static void rounds(ArrayList<player> playerList, ArrayList<player> playersIn, int roundCount, int playerTurnIndex, int blind, Scanner sc)
    {
        int currentBet = blind;
        int pot = blind;
        for (int i = 0; i<5; i++)
        {
            if (roundCount == 0)
            {
                //deal
            }
            else if (roundCount ==1)
            {
                //flop
            }
            else if (roundCount ==2)
            {
                //turn
            }
            else if (roundCount ==3)
            {
                //river
            }
            else if (roundCount ==4)
            {
                //final bets
            }
            while (nextRound(playerList,playersIn))
                {
                    for (int x=0; x<playerList.size();x++)
                        {
                            if(playerList.get(x).getCurrentBet() == currentBet)
                            {
                                currentBet+= promptBet(playerList, playerTurnIndex,sc);
                                pot+=promptBet(playerList, playerTurnIndex,sc);
                                playersIn.add(playerList.get(x));
                            }
                            else
                            {
                                promptCallFold(playerList,playerTurnIndex,sc,currentBet,playersIn, pot);

                            }
                        }
                }
                roundCount++;
        }
    }
    public static int promptBet(ArrayList<player> playerList, int playerTurnIndex, Scanner sc)
    {
        System.out.println("Bet?");

        return sc.nextInt();
    }
    public static void promptCallFold(ArrayList<player> playerList, int playerTurnIndex, Scanner sc,int currentBet,ArrayList<player> playersIn, int pot)
    {
        System.out.println("Call or Fold?");
        if (sc.nextLine().equals("Call"))
        {
            pot+= (currentBet - playerList.get(playerTurnIndex).getCurrentBet());
            playerList.get(playerTurnIndex).setCurrentBet(currentBet);
            playersIn.add(playerList.get(playerTurnIndex));

        }
        else
        {
            playerList.remove(playerTurnIndex);

        }
    } */
}
