import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * The hand controls the mechanics and decisions made in a game of blackjack, allowing the player to make the decision
 * while maintaining a threshold for the dealer to stop hitting
 */
public class Hand {
	private Player myPlayer;
	private Player myDealer;
	private Deck myDeck;
	private static int DEALER_THRESHOLD = 17;
	
	public Hand(Player player, Player dealer, Deck deck) {
		myPlayer = player;
		myDealer = dealer;
		myDeck = deck;
	}
	
	public boolean playHand() {
		int playerValue = getPlayerCards();
		if(playerValue > 21){
			System.out.println("You busted!");
			return false;
		}
		int dealerValue = getDealerCards();
		System.out.println("Dealer had " + Integer.toString(dealerValue) + ".");
		if(dealerValue > 21){
			System.out.println("Dealer busted!");
			return true;
		}
		if(playerValue >= dealerValue){
			return true;
		}
		return false;
	}

	private int getDealerCards(){
		myDealer.addCard(myDeck.getRandomCard());
		myDealer.addCard(myDeck.getRandomCard());
		while(totalScore(myDealer.getCards()) < DEALER_THRESHOLD){
			myDealer.addCard(myDeck.getRandomCard());
			System.out.println("Dealer hit.");
		}
		return totalScore(myDealer.getCards());
	}
	
	private int getPlayerCards(){
		myPlayer.addCard(myDeck.getRandomCard());
		myPlayer.addCard(myDeck.getRandomCard());
		boolean userPass = false;
		while(!userPass && totalScore(myPlayer.getCards()) < 21) {
			String response = "";
			while(!response.trim().equals("y") && !response.trim().equals("n")) {
				printHand(myPlayer);
				System.out.print("\n");
				System.out.println("Hit? Please enter single character (y/n)");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				try {
					response = br.readLine();
					if (response.trim().equals("y")) {
						userPass = false;
						myPlayer.addCard(myDeck.getRandomCard());
					} else if (response.trim().equals("n")) {
						userPass = true;
					}
				} catch(Exception e){
					response = "";
					System.out.println("Invalid response.");
				}
			}
		}
		printHand(myPlayer );
		System.out.print("\n");
		return totalScore(myPlayer.getCards());
	}

	private void printHand(Player player){
		System.out.print("This is your current hand: ");
		for(int i = 0; i < myPlayer.getCards().size(); i++) {
			System.out.print(myPlayer.getCards().get(i).getName());
			if(myPlayer.getCards().size() - 1 != i) {
				System.out.print(", ");
			}
		}
	}

	private int totalScore(List<Card> cards){
		List<Integer> scores = new ArrayList<>();
		int numAces = 0;
		int sum = 0;
		for(Card c:cards){
			if(c.getValues().size() == 2){
				numAces++;
			} else{
				sum += c.getValues().get(0);
			}
		}
		while(numAces > 0){
			numAces--;
			if(sum + numAces <= 10){
				sum += 11;
			} else{
				sum += 1;
			}
		}
		return sum;
	}
}
