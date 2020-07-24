
public class Deck {
	Card[][] deck;
	public Deck(int ace_value) {
		deck = generate_deck(ace_value);
	}
	public static Card[][] generate_deck(int ace_value) { // generates a deck
		
		Card[][] deck = new Card[4][13];
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 13; j++)
				deck[i][j] = new Card(i + 1, j + 2, ace_value);
		return deck;
	}
	public Card[][] getDeck() { // returns that deck
		return deck;
	}
}
