package GameTheory.Strategies;

public class EsteeLauderLuxury extends Strategy {
    @Override
    public int makeMove() {
        // Luxury branding cooperates unless the opponent defects 80% of the time
        long totalDefects = opponentMoveHistory.stream().filter(m -> m == 0).count();
        return (totalDefects < (0.8 * opponentMoveHistory.size())) ? 1 : 0;
    }

    @Override
    public String getStrategyName() {
        return "EsteeLauderLuxury";
    }
}
