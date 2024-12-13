package GameTheory.Strategies;

public class AlwaysCooperate extends Strategy {

    @Override
    public int makeMove() {
        return 1;
    }

    @Override
    public String getStrategyName() {
        return "AlwaysCooperate";
    }
}
