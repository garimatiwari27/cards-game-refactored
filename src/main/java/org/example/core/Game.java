package org.example.core;

import java.util.Comparator;

/**
 * * Game singleton class to run a cards game and declare the winner
 * 
 * @author garima
 *
 */

public class Game implements AutoCloseable, Comparator<Card> {

	private static Game instance;
	private Deck deck;
	private static final int TOTAL_CARDS_DELT = 5;

	private Game() {
		deck = new Deck(Constants.TOTAL_CARDS_IN_DECK);

	}

	public static Game getInstance() {
		if (instance == null)
			instance = new Game();
		return instance;
	}

	@Override
	public int compare(Card card1, Card card2) {
		return card1.getValue() - card2.getValue();
	}

	@Override
	public void close() throws Exception {
		System.out.println("Cleaning up instance");
		instance = null;

	}

	/**
	 * Method to start a cards-game with inputs as players
	 * 
	 * @param player1
	 * @param player2
	 */
	public void startGame(Player player1, Player player2) {

		for (int i = 0; i < TOTAL_CARDS_DELT; i++) {
			dealCardsForPlayer(player1);
			dealCardsForPlayer(player2);
		}
	}

	/**
	 * Method to deal cards for players
	 * 
	 * @param player
	 */
	public void dealCardsForPlayer(Player player) {
		player.addCard(deck.dealCard());
	}

	/**
	 * Method to retrieve hand value and print final winner
	 * 
	 * @param p1
	 * @param p2
	 * @return String as final result of the game
	 */
	public String getFinalHandValueAndPrintWinner(Player p1, Player p2) {
		Card c1 = null, c2 = null;

		c1 = retreiveHandValue(p1, c1);
		c2 = retreiveHandValue(p2, c2);

		return printWinner(c1, c2);
	}

	/**
	 * Method to return the final winner of the game
	 * 
	 * @param card1
	 * @param card2
	 * @return
	 */
	private String printWinner(Card card1, Card card2) {

		String result = Constants.TIE;

		if (compare(card1, card2) > 0)
			result = Constants.PLAYER_1_WINS;
		else if (compare(card2, card1) > 0)
			result = Constants.PLAYER_2_WINS;

		return result;

	}

	/**
	 * Method to retrieve hand value for the player
	 * 
	 * @param player
	 * @param card
	 * @return
	 */
	private Card retreiveHandValue(Player player, Card card) {

		for (Card c : player.showHand()) {
			if (card == null)
				card = c;
			else if (compare(c, card) > 0)
				card = c;

		}
		return card;
	}

}
