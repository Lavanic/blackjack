import java.util.ArrayList;
import java.util.Random; 
public class Bot extends Player
{
   private GameLogic game = new GameLogic();

   //Constructor for Bot object, takes a name and a number.
   public Bot(String name, int i)
   {
      super(name, i);
   }//Bot Constructor
   
   //Method which returns whether it is a bot.
   public boolean isBot()
   {
      return true;
   }//isBot method
   
   /*The botLogicOne method acts as game logic for bots choosing whether to
   hit or stand.*/
   public String botLogicOne(ArrayList<Player> activePlayers, int i)
   {
      Random rand = new Random(); 
      boolean feelRisky = false;
      int randType = rand.nextInt(1);
      //50% the bot will feel risky and hit between 11 and 15.
      if (randType == 1)
      {
         feelRisky = true;
      }//if
      GameLogic game = new GameLogic(activePlayers);
      int tempInt = activePlayers.get(i).handTotal();
      //if the total of their hand is under 11 or they're feeling risky then they hit.
      if (tempInt <= 11 || tempInt >= 11 && tempInt <= 15 && feelRisky)
      {
         Card tempCardOne = game.pullCard();
         activePlayers.get(i).addCard(tempCardOne);
         //if the total is over 21 then its a bust.
         if (tempInt > 21)
         {
            return activePlayers.get(i).getName() +  " pulls a... " + tempCardOne.getCard() + "\nOops their total is " +  activePlayers.get(i).handTotal() + "\n~---BUST YOU'RE OUT---~\n";
         }//if
         return activePlayers.get(i).getName() +  " pulls a... " + tempCardOne.getCard() ;
      }//if
      //if the total of their hand is over 15 or it's between 11 and 15 and they're not feeling risky they stand.
      else if (tempInt >= 15 || tempInt >= 11 && tempInt < 15 && !feelRisky)
      {
         return "They chose to stand!\n-----End of Turn-----\n";
      }//else if
      else
      {
         return ("Error");
      }//else
   }//botLogic method
   
     
   
}//class