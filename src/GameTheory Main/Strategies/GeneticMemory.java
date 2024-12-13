package GameTheory.Strategies;

public class GeneticMemory extends GeneticStrategy {

    public GeneticMemory(double n) {
        super(n);
    }

    /**
     * Make a move probabilistically; generate a random number between 0 and 1,
     * and if it is less than this.weight, and if the opponent's previous move
     * was cooperative, then cooperate.
     */
    @Override
    public int makeMove() {
        int opponentPrevMove = this.opponentMoveHistory.size() > 0
                ? this.opponentMoveHistory.get(this.opponentMoveHistory.size() - 1)
                : 1;
        return (opponentPrevMove == 1 && this.generator.nextDouble() < this.weight) ? 1 : 0;
    }

    /**
     * Mutate this genetic strategy by modifying its weight and returning a new
     * instance.
     */
    @Override
    public GeneticMemory mutateNew() {
        boolean pm = generator.nextDouble() > 0.5;
        double val = generator.nextDouble() * 0.008;
        double newWeight = pm && (weight + val < 1) ? weight + val : weight - val > 0 ? weight - val : weight;
        return new GeneticMemory(newWeight);
    }

    @Override
    public String getStrategyName() {
        return "GeneticMemory";
    }
}
