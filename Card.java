
public class Card {
	private int value;
	private String description = "v of s";
	private int suit;
	public Card(int cardSuit, int cardValue, int ace_value) { // creates a card based upon parameters passed
		suit = cardSuit;
		switch(suit) {
			case 1:
				description = description.replaceFirst("s", "Clubs");
				break;
			case 2:
				description = description.replaceFirst("s", "Diamonds");
				break;
			case 3:
				description = description.replaceFirst("s", "Hearts");
				break;
			case 4:
				description = description.replaceFirst("s", "Spades");
				break;
		}
		value = cardValue;
		
		switch(cardValue) {
			case 2:
				description = description.replace('v', '2');
				break;
			case 3:
				description = description.replace('v', '3');
				break;
			case 4:
				description = description.replace('v', '4');
				break;
			case 5:
				description = description.replace('v', '5');
				break;
			case 6:
				description = description.replace('v', '6');
				break;
			case 7:
				description = description.replace('v', '7');
				break;
			case 8:
				description = description.replace('v', '8');
				break;
			case 9:
				description = description.replace('v', '9');
				break;
			case 10:
				description = description.replaceFirst("v", "10");
				break;
			case 11:
				description = description.replaceFirst("v", "Jack");
				break;
			case 12:
				description = description.replaceFirst("v", "Queen");
				break;
			case 13:
				description = description.replaceFirst("v", "King");
				break;
			case 14:
				description = description.replaceFirst("v", "Ace");
				value = ace_value;
				break;
		}
		if(cardValue == 10 || cardValue == 11 || cardValue == 12 || cardValue == 13)
			value = 10;
	}
	public int getValue() {
		return value;
	}
	public String getDescription() {
		return description;
	}
}
