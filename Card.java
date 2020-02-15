public class Card
{
   private String suit;
   private String value;
   public Card (String suit, String value)
   {
      this.suit = suit;
      this.value = value;
   }//Card constructor
  
   //This method returns the Card as a string.
   public String getCard()
   {
      return(value + " of " + suit);
   }//getCard method
  
   public String getValue()
   {
      return value;
   }//getValue method
                                                                                            
}//Card class