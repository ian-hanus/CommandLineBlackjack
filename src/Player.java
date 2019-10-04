import java.util.*;

/**
 * Player struct that holds the state of the player: the cards and chips they have
 */
public class Player {
	private int myChips;
	private List<Card> myCards;
	
	public Player(int startingChips) {
		myChips = startingChips;
		myCards = new ArrayList<>();
	}
	
	public int getChips() {
		return myChips;
	}
	
	public List<Card> getCards(){
		return myCards;
	}

	public void addCard(Card card){
		myCards.add(card);
	}

	public void setChips(int chips){
		myChips = chips;
	}

	public void resetCards(){
		myCards = new ArrayList<>();
	}
}
