import java.util.ArrayList;
import java.util.List;

/**
 * Struct holding the state of each card, including how to print the card and card value(s)
 */
public class Card {
	private String myName;
	private List<Integer> myValues;
	
	public Card(String suit, String valueString, int value) {
		myName = valueString + " of " + suit;
		myValues = new ArrayList<>();
		myValues.add(value);
		if(valueString.equals("A")) {
			myValues.add(11);
		}
	}
	
	public String getName() {
		return myName;
	}
	
	public List<Integer> getValues(){
		return myValues;
	}

}
