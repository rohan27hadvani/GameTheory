package GameTheory.Strategies;

public class TitForTat extends Strategy {

    @Override
    public int makeMove() {
        if (opponentMoveHistory.isEmpty()) {
            return 1;
        }
        return opponentMoveHistory.get(opponentMoveHistory.size() - 1);
    }

    @Override
    public String getStrategyName() {
        return "TitForTat";
    }
}
