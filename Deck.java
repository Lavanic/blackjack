import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random; 
public class Deck
{
   private ArrayList<String> values = new ArrayList<String>(Arrays.asList( "King", "Queen", "Jack", "10", "9", "8", "7","6", "5", "4", "3", "2","Ace"));
   private ArrayList<String> suits = new ArrayList<String>(Arrays.asList("Clubs", "Diamonds", "Hearts", "Spades"));
   private ArrayList<Card> basicDeck = new ArrayList<Card>();
   private ArrayList<Card> modelDeck = new ArrayList<Card>();
   
   //This constructor initializes a full deck through nested for loops.
   public Deck()
   {
      for(int k = 0; k < 4; k++)
      {
         for(int h = 0; h < 13; h++)
         {
            Card temp = new Card(suits.get(k), values.get(h));
            basicDeck.add(temp);
            modelDeck.add(temp);
         }//inner inner for
      }//inner for 
   
   }//Deck Constructor
   
   //When a card is pulled in this method it is removed from the deck preventing duplicates.
   public Card pullCard()
   {
      //if the deck is almost out and someone is trying to hit then it adds new cards.
      if (basicDeck.size() <= 1)
      {
         for (int j = 0; j < 52; j++)
         {
            basicDeck.add(modelDeck.get(j));
         }
      }
      Random rand = new Random(); 
      int tempRand = rand.nextInt(basicDeck.size());
      Card tempCard = basicDeck.get(tempRand);
      basicDeck.remove(tempRand);
      return tempCard;
   }//pullCard method
   
   
}//Deck class