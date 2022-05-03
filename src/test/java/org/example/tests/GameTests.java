package org.example.tests;
import org.example.core.Card;
import org.example.core.Constants.Suite;
import org.example.core.Game;
import org.example.core.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameTests {
	private static final boolean IS_PLAYER_HAND_IS_EMPTY_BEFORE_SHUFFLE = true;
	private static final boolean IS_PLAYER_HAND_IS_EMPTY_AFTER_SHUFFLE = false;
	private static final Suite EXPECTED_DECK_CARD_SUITE = Suite.CLUBS;
	private static final int EXPECTED_DECK_CARD_VALUE = 1;

	private static final Game gameInstance = Game.getInstance();

	@Test
	@DisplayName("Test if the instances returned by the Game Singleton class are same")
	public void singletonGameInstanceCreation_returnsSameInstance() {

		// setup
		Game actualgameInstance = Game.getInstance();

		// verify
		Assertions.assertEquals(gameInstance, actualgameInstance);
	}

	@Test
	@DisplayName("Test if the player have any cards in hand after dealing")
	public void dealCardsForPlayer_returnsDealtCards() {

		// setup
		Player player = new Player();

		// verify before
		Assertions.assertEquals(checkIfPlayerHandIsEmpty(player), IS_PLAYER_HAND_IS_EMPTY_BEFORE_SHUFFLE);

		// execute
		gameInstance.dealCardsForPlayer(player);

		// verify after method call
		Assertions.assertEquals(checkIfPlayerHandIsEmpty(player), IS_PLAYER_HAND_IS_EMPTY_AFTER_SHUFFLE);
	}

	@Test
	@DisplayName("Both players get same card value and results in a tie")
	public void bothPlayersGetSameCard_resultsInATie() {

		// setup
		String expectedResult = "It's a Tie";
		
		Card input = new Card(EXPECTED_DECK_CARD_VALUE, EXPECTED_DECK_CARD_SUITE);

		// execute
		String actualResult = retreiveFinalWinnerInfo(input, input);

		// verify after method call
		Assertions.assertEquals(expectedResult, actualResult);
	}

	@Test
	@DisplayName("Player 1 get higher value card and wins the game")
	public void player1GetsHigherCard_resultsInPlayer1Winning() {

		// setup
		String expectedResult = "Player 1 Wins";

		Card player1CardInput = new Card(EXPECTED_DECK_CARD_VALUE + 1, EXPECTED_DECK_CARD_SUITE);
		Card player2CardInput = new Card(EXPECTED_DECK_CARD_VALUE, EXPECTED_DECK_CARD_SUITE);

		// execute
		String actualResult = retreiveFinalWinnerInfo(player1CardInput, player2CardInput);

		// verify after method call
		Assertions.assertEquals(expectedResult, actualResult);
	}

	@Test
	@DisplayName("Player 2 get higher value card and wins the game")
	public void player2GetsHigherCard_resultsInPlayer1Winning() {

		// setup

		String expectedResult = "Player 2 Wins";

		Card player1CardInput = new Card(EXPECTED_DECK_CARD_VALUE, EXPECTED_DECK_CARD_SUITE);
		Card player2CardInput = new Card(EXPECTED_DECK_CARD_VALUE + 1, EXPECTED_DECK_CARD_SUITE);

		// execute
		String actualResult = retreiveFinalWinnerInfo(player1CardInput, player2CardInput);

		// verify after method call
		Assertions.assertEquals(expectedResult, actualResult);
	}

	private boolean checkIfPlayerHandIsEmpty(Player player) {

		return player.showHand().isEmpty();
	}

	private String retreiveFinalWinnerInfo(Card player1Card, Card player2Card) {

		Player player1 = new Player();
		Player player2 = new Player();

		player1.addCard(player1Card);
		player2.addCard(player2Card);
		
		String actualResult = gameInstance.getFinalHandValueAndPrintWinner(player1, player2);
		return actualResult;

	}
}
