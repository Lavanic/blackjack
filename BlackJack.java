/*
Oliver Ohrt
Mr.Stutler  
APCSA P.4
30 January 2019
*/
//add one or eleven
//add multiple decks
//Add bots 
import java.util.ArrayList;
import java.util.Scanner;
public class BlackJack
{
   /*My main metho esentially gathers the players and names, then gathers the user input and passes it to
   logic methods, and prints out what they return */
   public static void main(String[] args)
   {
      System.out.println("---------Welcome To---------\n     -----BLACKJACK-----");
      Scanner console = new Scanner(System.in);
      ArrayList<Player> playerList = new ArrayList<Player>();
      boolean naming = true;
      int nameTemp = 1;
      int botCount = 1;
      //If the player types "stop" the naming sequence will end and the game will start.
      //If the player inputs "bot" then a bot will be added to the game.
      System.out.println("Type \"stop\" to stop adding players!\nType \"bot\" to add a bot to the game!");
      while (naming)
      {
         System.out.print("Enter name for player #" + nameTemp + ": ");
         String nameObject = console.nextLine();
         if (nameObject.equalsIgnoreCase("Stop") && nameTemp > 2)
         {
            naming = false;
         }//if
         //When the player tries to stop naming with less than two players a message is printed.
         else if (nameObject.equalsIgnoreCase("Stop") && nameTemp <= 2)
         {
            System.out.println("YOU NEED AT LEAST TWO PLAYERS TO START!!");
         }//if
         else if (nameObject.equalsIgnoreCase("bot"))
         {
            int i = botCount;
            botCount ++;
            Player tempPlayer = new Bot("Bot", i);
            playerList.add(tempPlayer);
            nameTemp++;
         }//if
         else
         {
            Player tempPlayer = new Player(nameObject);
            playerList.add(tempPlayer);
            nameTemp++;
         }//else
      }//while
      //Here is all my Game Logic being printed as I can only print in the client code.
      boolean gameGoing = true;
      while (gameGoing)
      {
         ArrayList<Player> activePlayers = new ArrayList<Player>();
         for(Player temp: playerList)
         {
            activePlayers.add(temp);
         }//for
         GameLogic game = new GameLogic(activePlayers);
         //Phase one of my GameLogic method is called.
         System.out.println("\n" + game.phaseOne());
         for (int i = 0; i < activePlayers.size(); i = i)
         {
            System.out.println("It is " + activePlayers.get(i).getName()  + "'s turn...");
            //Here if the current player is not a bot then my program gathers user input.
            if (!activePlayers.get(i).isBot())
            {
               System.out.println(activePlayers.get(i).getName() + " is holding " + activePlayers.get(i).isHolding() + "[" + activePlayers.get(i).handTotal() + "]");
               System.out.println("Do you choose to \"[h]it\" or \"[s]tand\"...");
               boolean roundEnd = false;
               while (roundEnd == false)
               {
                  String tempAnswer = console.nextLine();
                  String response = (game.phaseTwo(i, console, tempAnswer));
                  System.out.println(response);
                  if (response.equals("-----End of Turn-----\n"))
                  {
                     i++;
                     roundEnd = true;
                  }
                  else if ((response.substring(response.length() - 4, response.length()).equals("--~\n")))
                  {
                     activePlayers.remove(i);
                     roundEnd = true;
                  }//if
               }//while
            }//if
            //if the current player is a bot then it prints out strings from botLogic methods.
            else
            {
               boolean roundEnd = false;
               while (roundEnd == false)
               {
                  String response = activePlayers.get(i).botLogicOne(activePlayers, i);
                  System.out.println(response);
                  if (response.equals("They chose to stand!\n-----End of Turn-----\n"))
                  {
                     i++;
                     roundEnd = true;
                  }
                  else if ((response.substring(response.length() - 4, response.length()).equals("--~\n")) || response.equals("Error"))
                  {
                     activePlayers.remove(i);
                     roundEnd = true;
                  }//if
               }//while
            }//else
         
         }//for
         //Here the winners are printed and the user is prompted for another game.
         System.out.println(game.endGame(activePlayers));
         System.out.println(game.getScores(playerList));
         System.out.println("----PLAY AGAIN?----\ntype \"yes\" or \"no\"");
         String tempString = console.nextLine();
         if (tempString.equals("no"))
         {
            System.out.println("--THANK YOU FOR PLAYING BLACKJACK--");
            gameGoing = false;
         }//if
         else
         {
            for (Player temp : playerList)
            {
               temp.resetHand();
            }//for
         }//else
      }//while
   }//main method

}//BlackJack class