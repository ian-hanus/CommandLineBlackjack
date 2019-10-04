import java.util.*;

/**
 * Holds the state of the current hand, tracking which cards have been used/are available and providing the random card
 */
public class Deck {
	private List<Card> myAvailableCards;
	
	public Deck() {
		String[] suits = new String[] {"diamonds", "clubs", "hearts", "spades"};
		String[] valueStrings = new String[] {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		int[] values = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
		myAvailableCards = new ArrayList<>();

		for(String s:suits) {
			for(int i = 0; i < valueStrings.length; i++) {
				myAvailableCards.add(new Card(s, valueStrings[i], values[i]));
			}
		}
	}
	
	public Card getRandomCard() {
		Random r = new Random();
		int cardIndex = r.nextInt(myAvailableCards.size());
		Card card = myAvailableCards.get(cardIndex);
		myAvailableCards.remove(cardIndex);
		return card;
	}
	
}
