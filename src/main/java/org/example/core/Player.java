package org.example.core;

import java.util.ArrayList;
import java.util.List;

import org.example.core.impl.IPlayer;

/**
 * Class to holds the properties and behavior of a cards-game player
 * 
 * @author garima
 *
 */
public class Player implements IPlayer {

	private List<Card> hand;

	public Player() {
		hand = new ArrayList<Card>();

	}
	
	@Override
	public List<Card> showHand() {
		return hand;
	}
	
	@Override
	public String toString() {
		return "Player [hand=" + hand + "]";
	}


	/**
	 * Adds Card for Player's hand
	 * 
	 * @param card
	 */
	public void addCard(Card card) {
		if (card != null)
			hand.add(card);

	}

}
