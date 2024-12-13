package GameTheory.Strategies;

public class RevlonBroadDistribution extends Strategy {
    @Override
    public int makeMove() {
        // Broadly cooperates but defects if the opponent defects twice in a row
        if (opponentMoveHistory.size() >= 2) {
            int lastMove = opponentMoveHistory.get(opponentMoveHistory.size() - 1);
            int secondLastMove = opponentMoveHistory.get(opponentMoveHistory.size() - 2);
            return (lastMove == 0 && secondLastMove == 0) ? 0 : 1;
        }
        return 1; // Default to cooperation
    }

    @Override
    public String getStrategyName() {
        return "RevlonBroadDistribution";
    }
}
