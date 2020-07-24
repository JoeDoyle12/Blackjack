import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	public void play() {
		Scanner reader = new Scanner(System.in);
		System.out.print("What value would you like the aces to have (11 or 1): ");
		int ace_value = reader.nextInt();
		Blackjack myGame = new Blackjack(ace_value); // creates an instance of the Blackjack class
		myGame.play();
		System.out.println("The dealer's hand was: ");
		ArrayList<Card> hand = myGame.getHand();
		for(Card c : hand)
			System.out.println(c.getDescription()); // prints the cards in the dealer's hand using a for - each loop
		System.out.print("Would you like to play again? (yes/no) ");
		String reply = reader.next();
		if(reply.equals("yes")) { // repeat play until the player doesn't want to
			play();
		} else {
			System.out.println("You won " + myGame.getPlayer().getWinTotal()[0] + " games and the dealer won " + myGame.getPlayer().getWinTotal()[0] + " games.");
			System.out.println("Bye!");
		}
	}
}
