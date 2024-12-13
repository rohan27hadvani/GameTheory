package GameTheory;

import GameTheory.Strategies.Strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Game {

    private Strategy s1;
    private Strategy s2;

    private static final int bothCooperate = 24;
    private static final int bothDefect = 19;
    private static final int successDefect = 42;
    private static final int failureCooperate = 0;

    Game(Strategy s1, Strategy s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    List<Integer> executeGame(int numIterations) {
        for (int i = 0; i < numIterations; i++) {
            battle(s1, s2);
        }

        int s1Points = s1.getPoints();
        int s2Points = s2.getPoints();

        s1.clearStrategy();
        s2.clearStrategy();

        return new ArrayList<>(Arrays.asList(s1Points, s2Points));
    }

    private void battle(Strategy s1, Strategy s2) {
        int s1Move = s1.makeMove();
        int s2Move = s2.makeMove();

        s1.addOpponentMove(s2Move);
        s2.addOpponentMove(s1Move);

        if (s1Move == 1 && s2Move == 1) {
            s1.addOutcome(bothCooperate);
            s2.addOutcome(bothCooperate);
        } else if (s1Move == 1) {
            s1.addOutcome(failureCooperate);
            s2.addOutcome(successDefect);
        } else if (s2Move == 1) {
            s1.addOutcome(successDefect);
            s2.addOutcome(failureCooperate);
        } else {
            s1.addOutcome(bothDefect);
            s2.addOutcome(bothDefect);
        }
    }
}
