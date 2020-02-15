import java.util.ArrayList;
import java.util.Scanner;
public class GameLogic
{
   private ArrayList<Player> players = new ArrayList<Player>();
   private Deck deck = new Deck();
   public GameLogic(ArrayList<Player> players)
   {
      this.players = players;
   }//GameLogic constructor

   //Constructor in which no parameters are needed.
   public GameLogic()
   {
   }//GameLogic constructor 
   
   //the phaseOne method basically prints who shows what card.
   public String phaseOne()
   {
      String last = "";
      for(int j = 0; j < players.size(); j++)
      {
         Player temp = players.get(j);
         temp.addCard(deck.pullCard());
         Card oneTemp = deck.pullCard();
         last += (temp.getName() + " shows the " + oneTemp.getCard() + "\n");
         temp.addCard(oneTemp);
      }//for
      return last += "------------------------";
   }//phaseOne method
   
   //This method is for real players and returns Strings based on user input.
   public String phaseTwo(int playerNum, Scanner console, String tempAnswer)
   {   
      String last = "";
      Player temp = players.get(playerNum);
      if (tempAnswer.equalsIgnoreCase("Hit") || tempAnswer.equalsIgnoreCase("h") )
      {
         Card tempCardOne = deck.pullCard();
         temp.addCard(tempCardOne);
         //If the players hand total goes over 21 then its a bust.
         if (temp.handTotal() > 21)
         {
            return "You pull a... " + tempCardOne.getCard() + "\nOops your total is " + temp.handTotal() + "\n~---BUST YOU'RE OUT---~\n";
         }//if
         last += ("You pull a... " + tempCardOne.getCard() + ("\nYou are holding " + temp.isHolding() + "[" + temp.handTotal() + "]"));
         last += ("\nDo you chose to \"[h]it\" or \"[s]tand\"...");
         return last;
      }//if
      else if (tempAnswer.equalsIgnoreCase("Stand") || tempAnswer.equalsIgnoreCase("s"))
      {
         return "-----End of Turn-----\n";
      }//else if
      return ("Improper Input");
   }//phaseTwo method
    
   //This method prints out the winners and scores of players.
   public String endGame(ArrayList<Player> activePlayers)
   {
      //If there is at least one winner
      if (activePlayers.size() != 0)
      {
         ArrayList<Player> winners = new ArrayList<Player>();
         int priorBest = 0;
         int bestScore =  activePlayers.get(0).handTotal();
         for (Player temp: activePlayers)
         {
            if (temp.handTotal() > bestScore && temp.handTotal() > priorBest)
            {
               int tempVal = bestScore;
               bestScore = temp.handTotal();
               priorBest = tempVal;
            }//if
         
         }//for
         for (Player temp: activePlayers)
         {
            if (temp.handTotal() == bestScore)
            {
               winners.add(temp);
            }//if
         }//for
         for (Player temp: winners)
         {
            temp.addScore(1.0 / winners.size());
         }//for
         String last = "";
         //Proper grammar if there is just one winner
         if (winners.size() > 1)
         {
            last = "The Winners Are... ";
         }//if
         //Proper grammar if there are multiple winners.
         if (winners.size() == 1)
         {
            last = "The Winner is.... ";
         }
         for (Player temp: winners)
         {
            last += temp.getName() + "(" + temp.handTotal() + ")";
            if (winners.size() > 1)
            {
               last += " and ";
            }//if
         
         }//for
         if (winners.size() > 1)
         {
            //Removes the last and (fencepost problem).
            last = last.substring(0, last.length() - 4);
         }//if
      
         return last;
      }//if
      else
      {
         return "----NO WINNERS----";
      }//else
   }//endGame method

   //This method returns each player and their score.
   public String getScores(ArrayList<Player> playerList)
   {
      String last = "";
      for(Player temp: playerList)
      {
         last += (temp.getName() + " has " + temp.getScore() + " wins!\n");
      }//for
      return last;
   }//getScores method
   
   //Needed method to act as gateway.
   public Card pullCard ()
   {
      return deck.pullCard();
   }//pullCard method
   

}//GameLogic class
