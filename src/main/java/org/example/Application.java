package org.example;

import org.example.core.Game;

/*
 * Class to run the main cards game application
 */
import org.example.core.Player;

/**
 * Main Application class to initiate the cards-game
 * 
 * @author garima
 *
 */
public class Application {

	public static void main(String[] args) {

		try (Game game = Game.getInstance()) {

			Player player1 = new Player();
			Player player2 = new Player();

			game.startGame(player1, player2);

			System.out.println(player1.showHand());
			System.out.println(player2.showHand());

			String result = game.getFinalHandValueAndPrintWinner(player1, player2);

			System.out.println(result);

		} catch (Exception exception) {

			System.out.println(exception.getMessage());

		}

	}
}
