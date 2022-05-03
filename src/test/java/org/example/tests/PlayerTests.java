package org.example.tests;

import java.util.ArrayList;
import java.util.List;

import org.example.core.Card;
import org.example.core.Constants.Suite;
import org.example.core.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTests {
	private static final Suite EXPECTED_DECK_CARD_SUITE = Suite.HEARTS;
	private static final int EXPECTED_DECK_CARD_VALUE = 10;
	private static final int EXPECTED_SIZE_OF_HAND = 1;

	@Test
	@DisplayName("Test the behaviur of addCard  and showHand method by adding 1 card in Player's hand and validate that values match")
	public void add1CardForPlayer_resultsInCountOfCardsAs1() {

		// setup
		Player player = new Player();
		Card cardInput = new Card(EXPECTED_DECK_CARD_VALUE, EXPECTED_DECK_CARD_SUITE);
		List<Card> expectedHand = new ArrayList<Card>();
		expectedHand.add(cardInput);

		// execute
		player.addCard(cardInput);

		// verify
		Assertions.assertEquals(EXPECTED_SIZE_OF_HAND, player.showHand().size());
		Assertions.assertEquals(expectedHand, player.showHand());

	}

}
