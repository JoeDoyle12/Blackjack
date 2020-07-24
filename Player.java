import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	private int playerTotal = 0;
	private boolean playerActive = true;
	private int[] winTotals = new int[2];
	public Card deal(Card[][] deck, int ace_value) { // to deal
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
			deal(deck, ace_value);
		}
		deck[i][j] = null;
		return null;
	}
	public void playerHit(Card[][] deck, ArrayList<Card> hand, Dealer dealer, int ace_value) { // hits the player
		Card card = deal(deck, ace_value);
		playerTotal += card.getValue();
		System.out.println("You drew a " + card.getDescription());
		prompt(deck, hand, dealer, ace_value);
	}
	public void discreetHit(Card[][] deck, int ace_value) {
		Card card = deal(deck, ace_value);
		playerTotal += card.getValue();
		System.out.println("You drew a " + card.getDescription());
	}
	public void prompt(Card[][] deck, ArrayList<Card> hand, Dealer dealer, int ace_value) { // lets the player decide what to do
		if(playerActive) {
			Scanner reader = new Scanner(System.in);
			System.out.print("Would like to hit or stay? Your total is " + playerTotal + " ");
			String answer = reader.next();
			if(answer.equals("hit")) {
				if(playerTotal == 21) {
					System.out.println("You win!");
					return;
				}
				playerHit(deck, hand, dealer, ace_value);
			} else if(answer.equals("stay")) {
				playerActive = false;
				if(playerTotal == 21) {
					System.out.println("You win!");
					return;
				}
				dealer.dealerHit(deck, hand, ace_value);
				dealer.dealerPlay(deck, hand, ace_value);
				winner(dealer);
			} else {
				System.out.println("I couldn't understand that, maybe try again? ");
				prompt(deck, hand, dealer, ace_value);
			}
		}
	}
	public void winner(Dealer dealer) { // decides the winner
		if(playerTotal > 21 && dealer.getDealerTotal() > 21) { // I added a case for if both go over. Thank you for letting me resubmit twice! Happy 4th of July!
			System.out.println("Noone wins. Your total was " + playerTotal);
			System.out.println("The dealer's total was " + dealer.getDealerTotal());
		} else if(playerTotal > 21) {
			System.out.println("You lose. Your total was " + playerTotal);
			System.out.println("The dealer's total was " + dealer.getDealerTotal());
		} else if(playerTotal > dealer.getDealerTotal() && playerTotal < 21 && dealer.getDealerTotal() < 21) {
			System.out.println("You win. Your total was " + playerTotal);
			System.out.println("The dealer's total was " + dealer.getDealerTotal());
		} else if (dealer.getDealerTotal() >= playerTotal && playerTotal < 21 && dealer.getDealerTotal() <= 21){
			System.out.println("You lose. Your total was " + playerTotal);
			System.out.println("The dealer's total was " + dealer.getDealerTotal());
			System.out.println(winTotals[1]);
		} else if (playerTotal == 21 && dealer.getDealerTotal() != 21) {
			System.out.println("You win. Your total was " + playerTotal);
			System.out.println("The dealer's total was " + dealer.getDealerTotal());
		} else if (dealer.getDealerTotal() == 21 && playerTotal != 21) {
			System.out.println("You lose. Your total was " + playerTotal);
			System.out.println("The dealer's total was " + dealer.getDealerTotal());
		} else if(dealer.getDealerTotal() > 21) {
			System.out.println("You win. Your total was " + playerTotal);
			System.out.println("The dealer's total was " + dealer.getDealerTotal());
		}
	}
	public int[] getWinTotal() {
		return winTotals;
	}
	
}
