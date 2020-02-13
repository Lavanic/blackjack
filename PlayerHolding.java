import java.util.ArrayList;
import java.util.Arrays;
public class PlayerHolding
{
   private ArrayList<Card> holding = new ArrayList<Card>();

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

   public void addCard(Card card)
   {
      holding.add(card);
   }//addCard method

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

   public void resetHand()
   {
      for (int i = 0; i < holding.size(); i++)
      {
         holding.remove(0);
      }//for
   }//resetHand method
   
}//PlayerHolding class