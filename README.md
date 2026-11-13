# blackjack

tui blackjack, written for APCSA in early 2020.

any number of players, bots to play against, a win count, and a play
again loop.

```
---------Welcome To---------
     -----BLACKJACK-----
Type "stop" to stop adding players!
Type "bot" to add a bot to the game!
Enter name for player #1: Oliver
Enter name for player #2: bot
Enter name for player #3: bot
Enter name for player #4: stop

Oliver shows the 2 of Diamonds
Bot 1 shows the Ace of Diamonds
Bot 2 shows the 4 of Hearts
------------------------
It is Oliver's turn...
Oliver is holding [10 of Clubs, 2 of Diamonds][12]
Do you choose to "[h]it" or "[s]tand"...
h
You pull a... 9 of Hearts
You are holding [10 of Clubs, 2 of Diamonds, 9 of Hearts][21]
Do you chose to "[h]it" or "[s]tand"...
s
-----End of Turn-----
```

- `BlackJack.java`: main. takes the names, runs the turns and prints
  what the logic hands back.
- `GameLogic.java`: the deal, hit or stand, and who won.
- `Player.java` and `Bot.java`: a hand and a score. bots hit on 11 or
  under and stand on anything over.
- `Deck.java` and `Card.java`: 52 cards, pulled at random.
- `PlayerHolding.java`: the hand as its own class, saved the day before
  the rest. its methods moved into `Player` and it stayed out of the zip.
  kept as found.
- `StudentTeam.txt`: the team file that went in with it.

run it with `javac *.java && java BlackJack`. the zip as I handed it in,
compiled classes included, is under releases.

archived from my old windows drive in 2026.
