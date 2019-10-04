## Run Instructions

Download the Blackjack_KP.jar file in the root of master

Make sure that Java 11 is installed

Navigate to the directory with the downloaded Blackjack_KP.jar and run the command 

`` java -jar Blackjack_KP.jar
``

## Game Instructions
Enter the number of chips that you wish to begin with. Next, a hand will start and ask you how much you want to be. You may bet as many
chips as you have or fewer. You will then be shown your hand and given a choice whether you want to hit or not. Type 'y' and enter for yes,
'n' and enter for no. The dealer will automatically be playing against you. The game ends when you run out of chips, or choose to quit the
program.

## Design 
The overall design of the game was fairly simple. A deck object was created, full of all possible cards (represented by card objects that held the 
defining characteristics and displayable characteristics of the cards). The deck had a function making the distribution of cards from 
the hand easy and fair. These cards would be distributed to players, one of whom would be the user who would be asked for input. The other
player would be the dealer, or house, and would have unlimited chips and always hit while he was below a certain threshold (in this case 
17). This whole process would start in the main class, and repeat until the player runs out of chips.

## Tooling choice
I chose Java to complete this task both because it is my most comfortable language and it also easily builds into an executable jar file
which makes playing through the command line easy. It is obvious that an object oriented programming language is necessary, but I believe
this assignment could have been done well in a number of languages such as C++ or Python.
