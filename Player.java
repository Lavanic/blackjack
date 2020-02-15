import java.util.Arrays;
import java.util.ArrayList;
public class Player
{
   private String name;
   private double score;
   private ArrayList<Card> holding = new ArrayList<Card>();

   //This constructor is for actual players.
   public Player (String name)
   {
      this.name = name;
      this.score = 0.0;
   }//Player constructor
   
   //This constructor is for bots as i represents their number.
   public Player (String name, int i)
   {
      this.name = name + " " + i;
      this.score = 0.0;
   }//Player constructor

   //This method returns name of player.
   public String getName()
   {
      return name;
   }//getName method
 
   /*This method returns the score of the given player and
   includes a neat rounding system*/
   public double getScore()
   {
      score *= 10;
      Math.round(score);
      score /= 10;
      return score;
   }//getScore method
 
   //This method adds score to the players total.
   public void addScore(double amount)
   {
      this.score = score + amount;
   }//addScore method

   //This method returns all the cards the player is currently holding.
   public String isHolding()
   {
      String last = "[";
      for (int i = 0; i < holding.size(); i++)
      {
         last += holding.get(i).getCard();
         if (i < holding.size() - 1)
         {
            last += ", ";
         }//if
      }//for
      last += "]";
      return last;
   }//isHolding method

   //This method adds a card to the players hand.
   public void addCard(Card card)
   {
      holding.add(card);
   }//addCard method

   //This method returns the total value of all the given cards in the players hand
   public int handTotal()
   {
      int last = 0;
      for (int i = 0; i < holding.size(); i++)
      {
         if (holding.get(i).getValue().equals("King") || holding.get(i).getValue().equals("Queen") || holding.get(i).getValue().equals("Jack"))
         {
            last += 10;
         }//if
         else if (holding.get(i).getValue().equals("Ace"))
         {
            last += 1;
         }//else if
         else
         {
            last += Integer.parseInt(holding.get(i).getValue());
         }//else
      }//for
      return last;
   }//handTotal method

   /*This method resets the hand of the given player and is 
   utilized at the end of the game if the player choses "yes"*/
   public void resetHand()
   {
      int tempInt =  holding.size();
      for (int i = 0; i < tempInt; i++)
      {
         holding.remove(0);
      }//for
   }//resetHand method
   
   //Method which returns whether the given player is also a bot.
   public boolean isBot()
   {
      return false;
   }//isBot method
  
   /*This method was neccesary as jGrasp would complain that it
   could'nt find this method in Player even though it was meant for
   the Bot class.*/
   public String botLogic()
   {
      return "ERROR SHOULD NOT PRINT";
   }//method
   
   /*This method was neccesary as jGrasp would complain that it
   could'nt find this method in Player even though it was meant for
   the Bot class.*/
   public String botLogicOne(ArrayList<Player> activePlayers, int i)
   {
      return "ERROR SHOULD NOT PRINT";
   }//method 
}//Player class