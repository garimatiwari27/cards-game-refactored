package org.example.core;

import org.example.core.Constants.Suite;

/**
 * Card class to hold the properties of the Card
 * 
 * @author garima
 *
 */
public class Card {
	// declare class variables as private
	private Suite suite;
	private int value;

	public Card(int value, Suite suite) {
		this.value = value;
		this.suite = suite;
	}

	// generate getters
	public int getValue() {
		return value;
	}

	public Suite getSuite() {
		return suite;
	}

	@Override
	public String toString() {
		return "Card [suite=" + getSuite() + ", value=" + getValue() + "]";
	}

}
