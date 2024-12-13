package GameTheory.Strategies;

public class AlwaysDefect extends Strategy {

    @Override
    public int makeMove() {
        return 0;
    }

    @Override
    public String getStrategyName() {
        return "AlwaysDefect";
    }
}
