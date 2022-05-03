package org.example.core;

import java.util.ArrayList;

import org.example.core.Constants.Suite;
import org.example.core.impl.IDeckCard;

/**
 * Deck Class that holds the properties and behaviors of the deck
 * 
 * @author garima
 *
 */
public class Deck implements IDeckCard {

	private ArrayList<Card> deck = new ArrayList<Card>();

	public Deck() {
	}

	public Deck(int totalCardsInDeck) {
		generateDeckOfCards(totalCardsInDeck);
	}

	public ArrayList<Card> getDeck() {
		return deck;
	}

	/**
	 * Method to generate deck of cards
	 * 
	 * @param totalCardsInDeck
	 */
	private void generateDeckOfCards(int totalCardsInDeck) {
		for (int i = 1; i <= totalCardsInDeck; i++) {
			deck.add(new Card(i, Suite.CLUBS));
			deck.add(new Card(i, Suite.DIAMONDS));
			deck.add(new Card(i, Suite.HEARTS));
			deck.add(new Card(i, Suite.SPADES));
		}
	}

	/**
	 * method to deal cards
	 * 
	 * @return Card which was dealt
	 */
	public Card dealCard() {
		int rand = (int) (Math.random() * ((deck.size() - 1)));
		Card c = deck.get(rand);
		deck.remove(c);
		return c;
	}

	@Override
	public void shuffleCards(int totalCardsInDeck) {
		// TODO Auto-generated method stub

	}

}
