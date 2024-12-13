package GameTheory.Strategies;

public class RevlonInnovative extends Strategy {
    @Override
    public int makeMove() {
        // Innovates by cooperating after every two defects
        int totalDefects = (int) opponentMoveHistory.stream().filter(m -> m == 0).count();
        return (totalDefects % 3 != 0) ? 1 : 0;
    }

    @Override
    public String getStrategyName() {
        return "RevlonInnovative";
    }
}
