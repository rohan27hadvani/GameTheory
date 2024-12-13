package GameTheory.Strategies;

public class EsteeLauderSustainable extends Strategy {
    @Override
    public int makeMove() {
        // Sustainable practices cooperate 90% of the time but defect occasionally
        return Math.random() > 0.1 ? 1 : 0;
    }

    @Override
    public String getStrategyName() {
        return "EsteeLauderSustainable";
    }
}
