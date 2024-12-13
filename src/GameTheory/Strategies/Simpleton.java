package GameTheory.Strategies;

/**
 * Simpleton Strategy
 *
 * Inspired by "The Evolution of Trust" (https://ncase.me/trust/).
 * 
 * This strategy adapts based on the opponent's last move:
 * - If the opponent cooperates, Simpleton copies its previous move.
 * - If the opponent defects, Simpleton does the opposite of its previous move.
 */
public class Simpleton extends Strategy {

    private int prevMove;

    public Simpleton() {
        super();
        this.prevMove = 1; // Default starting move is cooperation
    }

    @Override
    public int makeMove() {
        int move;

        if (opponentMoveHistory.isEmpty()) {
            // Default move: Cooperate if no history
            move = 1;
        } else if (opponentMoveHistory.get(opponentMoveHistory.size() - 1) == 1) {
            // If opponent cooperates, repeat previous move
            move = prevMove;
        } else {
            // If opponent defects, do the opposite of the last move
            move = (prevMove == 1) ? 0 : 1;
        }

        prevMove = move; // Update previous move for next round
        return move;
    }

    @Override
    public String getStrategyName() {
        return "Simpleton";
    }
}
