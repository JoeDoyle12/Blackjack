import java.util.ArrayList;

public class Dealer {
	private int dealerTotal = 0;
	public void dealerHit(Card[][] deck, ArrayList<Card> hand, int ace_value) { // draws a card and adds its value to the dealer's total
		Card card = dealerDeal(deck, ace_value);
		dealerTotal += card.getValue();
		hand.add(card);
		return;
	}
	public void discreetDealerHit(Card[][] deck, ArrayList<Card> hand, int ace_value) {
		Card card = dealerDeal(deck, ace_value);
		dealerTotal += card.getValue();
		hand.add(card);
		System.out.println("The Dealer's face-up card is a " + card.getDescription());
	}
	public Card dealerDeal(Card[][] deck, int ace_value) { // to deal
		Card[][] testDeck = new Card[4][13];
		for(Card[] i : testDeck) {
			for(Card j : i)
				j = null;
		}
		int i = (int) (Math.random() * 4);
		int j = (int) (Math.random() * 13);
		if(deck.equals(testDeck)) {
			for(int a = 0; i < deck.length; i++) {
				for(int b = 0; b < deck[a].length; b++) {
					deck[a][b] = new Card(a + 1, b + 2, ace_value);
				}
			}
		}
		try {
			return deck[i][j];
		} catch (NullPointerException ex) {
			dealerDeal(deck, ace_value);
		}
		deck[i][j] = null;
		return null;
	}
	public void dealerPlay(Card[][] deck, ArrayList<Card> hand, int ace_value) { // the "brains" of the dealer
		while(dealerTotal < 17) {
			dealerHit(deck, hand, ace_value);
		}
	}
	public int getDealerTotal() { // returns the dealer's total at the end
		return dealerTotal;
	}
}
