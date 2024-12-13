package GameTheory.Strategies;

public class TitForTatTat extends Strategy {

    /**
     * Strategy from the Evolution of Trust (https://ncase.me/trust/)
     *
     * This strategy (Tit-For-TatTat) will defect if the previous two moves of the
     * opponent were defections.
     */

    public TitForTatTat() {
        super();
    }

    @Override
    public int makeMove() {
        if (opponentMoveHistory.size() < 2) {
            return 1; // Cooperate if there are fewer than two moves in history
        }
        int lastMove = opponentMoveHistory.get(opponentMoveHistory.size() - 1);
        int secondLastMove = opponentMoveHistory.get(opponentMoveHistory.size() - 2);
        return (lastMove == 0 && secondLastMove == 0) ? 0 : 1; // Defect if the last two moves were defections
    }

    @Override
    public String getStrategyName() {
        return "TitForTatTat";
    }
}
