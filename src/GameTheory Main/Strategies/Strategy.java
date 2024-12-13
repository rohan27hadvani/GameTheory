package GameTheory.Strategies;

import java.util.ArrayList;
import java.util.List;

public abstract class Strategy {
    protected List<Integer> opponentMoveHistory = new ArrayList<>();
    private int points = 0;

    public abstract int makeMove(); // Change return type to int

    public void addOpponentMove(int move) { // Accept int instead of boolean
        opponentMoveHistory.add(move);
    }

    public void addOutcome(int outcome) {
        points += outcome;
    }

    public int getPoints() {
        return points;
    }

    public void clearStrategy() {
        opponentMoveHistory.clear();
        points = 0;
    }

    public abstract String getStrategyName();
}
