import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Main class to run the game; creates Players (player and dealer) and allows the player to change bet each time.
 * Exits when player runs out of chips.
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to Blackjack!");
		int startingChips = getStarting();
		Player player = new Player(startingChips);
		Player dealer = new Player(Integer.MAX_VALUE);
		while(player.getChips() > 0){
			int betAmount = getBet(player);
			System.out.println("Starting new game");
			Hand hand = new Hand(player, dealer, new Deck());
			boolean playerWon = hand.playHand();
			if(playerWon){
				player.setChips(player.getChips() + betAmount);
				System.out.println("You won!");
			} else{
				player.setChips(player.getChips() - betAmount);
				System.out.println("Dealer won.");
			}
			player.resetCards();
			dealer.resetCards();
			System.out.println("You have " + Integer.toString(player.getChips()) + " chips left");
		}
		System.out.println("Out of chips, game over");
	}

	private static int getStarting() {
		int starting = -1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(starting < 0) {
			try {
				System.out.print("Please enter the number of chips you wish to start with: ");
				starting = Integer.parseInt(br.readLine());
				if(starting < 0) {
					throw new RuntimeException();
				}
			} catch(Exception e){
				System.out.println("Invalid entry for starting chips value.");
			}
		}
		return starting;
	}
	
	private static int getBet(Player player) {
		int bet = -1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(bet < 0) {
			try {
				System.out.print("Please enter your bet: ");
				bet = Integer.parseInt(br.readLine());
				if(player.getChips() - bet < 0 || bet < 0) {
					throw new RuntimeException();
				}
			} catch(Exception e){
				System.out.println("Invalid entry for bet. You have " + Integer.toString(player.getChips()) + " chips left.");
				bet = -1;
			}
		}
		return bet;
	}
}
