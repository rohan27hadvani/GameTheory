package GameTheory;

import GameTheory.Strategies.Strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Game {

    static void setupDefaultPayoffs() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static void setupCustomPayoffs() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

	/**
	 * Game Class
	 *
	 * Hold games with strategies s1 and s2, where the rewards for cooperating and defecting are below.
	 * Different games with different weights should be explored!
	 *
	 * Rewards
	 * ----------| Cooperate         | Defect
	 * ----------|-------------------| -----------------
	 * Cooperate | 2                 | -1, 3 to defector
	 * Defect    | 3 to defector, -1 | 0
	 */

	private Strategy player1;
	private Strategy player2;
       

	private static final int bothCooperate = 1;
	private static final int bothDefect = 0;
	private static final int successDefect = 4;
	private static final int failureCooperate = 2;

	Game(Strategy s1, Strategy s2) {
		this.player1 = s1;
		this.player2 = s2;
	}

	/**
	 * Execute 1 game numIterations times
	 *
	 * @return a tuple of their scores
	 */
	List<Integer> executeGame(int numIterations) {

		if (numIterations < 0) {
			throw new RuntimeException("number of iterations of a game must be greater than 0");
		}

		for (int i = 0; i < numIterations; i++) {
			battle(player1, player2);
		}

		int s1Points = player1.getPoints();
		int s2Points = player2.getPoints();

		player1.clearStrategy();
		player2.clearStrategy();

		return new ArrayList<>(
				Arrays.asList(s1Points, s2Points)
		);
	}

	/**
	 * Hold a battle between s1 and s2; this is the classic
	 * prisoners dilemma cooperate / defect game.
	 *
	 * @param s1 first strategy
	 * @param s2 second strategy
	 * @return A tuple of moves of s1 and s2
	 */
	private void battle(Strategy s1, Strategy s2) {

		// Make your moves
		int s1Move = s1.makeMove(true); //True means, it is only player 1
		int s2Move = s2.makeMove(false); //False means, it is only player 2

		// Give the opponents moves to each player
		s1.addOpponentMove(s2Move);
		s2.addOpponentMove(s1Move);
                
                s1.addOpponentMovePlayer1(s1Move);
                s2.addOpponentMovePlayer2(s2Move);
                 // Determine payoffs based on the Pricing Game dilemma

   // Assign payoffs based on the moves
if (s1Move == 1 && s2Move == 4) {
    // Both cooperate
    s1.addOutcome(24);
    s2.addOutcome(24);
    s1.setPlayer1Score(24);
    s2.setPlayer2Score(24);
    //System.out.println("Player 1: " + s1.getPoints());
    //System.out.println("Player 2: " + s2.getPoints());
} else if (s1Move == 2 && s2Move == 4) {
    // s1 cooperates, s2 defects
    s1.addOutcome(30);
    s2.addOutcome(0);
    s1.setPlayer1Score(30);
    s2.setPlayer2Score(0);
} else if (s1Move == 3 && s2Move == 4) {
    // s2 cooperates, s1 defects
    s1.addOutcome(36);
    s2.addOutcome(0);
    s1.setPlayer1Score(36);
    s2.setPlayer2Score(0);
} 
if (s1Move == 1 && s2Move == 5) {
    // Both cooperate
    s1.addOutcome(36);
    s2.addOutcome(60);
    s1.setPlayer1Score(36);
    s2.setPlayer2Score(60);
    //System.out.println("Player 1: " + s1.getPoints());
    //System.out.println("Player 2: " + s2.getPoints());
} else if (s1Move == 2 && s2Move == 5) {
    // s1 cooperates, s2 defects
    s1.addOutcome(18);
    s2.addOutcome(18);
    s1.setPlayer1Score(18);
    //s2.setPlayer2Score(18);
    s2.setPlayer2Score(18);
   // s2.setPlayer2Score(60);
} else if (s1Move == 3 && s2Move == 5) {
    // s2 cooperates, s1 defects
    s1.addOutcome(60);
    s2.addOutcome(0);
    s1.setPlayer1Score(60);
    s2.setPlayer2Score(0);
}
if (s1Move == 1 && s2Move == 6) {
    // Both cooperate
    s1.addOutcome(0);
    s2.addOutcome(36);
    s1.setPlayer1Score(0);
    s2.setPlayer2Score(36);
    //System.out.println("Player 1: " + s1.getPoints());
    //System.out.println("Player 2: " + s2.getPoints());
} else if (s1Move == 2 && s2Move == 6) {
    // s1 cooperates, s2 defects
    s1.addOutcome(10);
    s2.addOutcome(36);
    s1.setPlayer1Score(10);
    s2.setPlayer2Score(36);
} else if (s1Move == 3 && s2Move == 6) {
    // s2 cooperates, s1 defects
    s1.addOutcome(6);
    s2.addOutcome(6);
    s1.setPlayer1Score(6);
    s2.setPlayer2Score(6);
}

	}
}
        