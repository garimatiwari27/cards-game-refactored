package org.example.tests;

import org.example.core.Constants;
import org.example.core.Deck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeckTests {
	private static final int TOTAL_CARDS_IN_DECK = 52;

	@Test
	@DisplayName("Test if the deal card method reduces the number of cards by 1")
	public void dealCardsInTheDeck_reducesTheNumberOfCardsBy1() {

		// setup
		Deck deck = new Deck(Constants.TOTAL_CARDS_IN_DECK);

		// execution
		deck.dealCard();
		int actualCardCount = deck.getDeck().size();

		// verify
		Assertions.assertEquals(TOTAL_CARDS_IN_DECK - 1, actualCardCount);
	}

}
