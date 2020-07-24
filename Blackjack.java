import java.util.ArrayList;

public class Blackjack {
	Dealer dealer;
	ArrayList<Card> compHand = new ArrayList<> ();
	Player player;
	Deck myDeck;
	Card[][] deck;
	int ace_value;
	public Blackjack(int value) {
		dealer = new Dealer(); // initiates objects for the dealer, player and deck
		player = new Player();
		myDeck = new Deck(value);
		deck = myDeck.getDeck();
		ace_value = value;
	}
	public void play() {
		dealer.discreetDealerHit(deck, compHand, ace_value); // begins the game
		player.discreetHit(deck, ace_value);
		player.playerHit(deck, compHand, dealer, ace_value);
	}
	public ArrayList<Card> getHand() {
		return compHand; // can return the dealer's hand, which will be useful for the end of the game
	}
	public Player getPlayer() {
		return player;
	}
}
