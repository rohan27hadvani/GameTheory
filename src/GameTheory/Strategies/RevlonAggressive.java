package GameTheory.Strategies;

public class RevlonAggressive extends Strategy {
    @Override
    public int makeMove() {
        // Aggressively defects 75% of the time
        return Math.random() > 0.75 ? 1 : 0;
    }

    @Override
    public String getStrategyName() {
        return "RevlonAggressive";
    }
}
