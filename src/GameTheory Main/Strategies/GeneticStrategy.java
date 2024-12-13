package GameTheory.Strategies;

import java.util.Random;

public abstract class GeneticStrategy extends Strategy {

    /**
     * This class is a genetic algorithm that acts on no knowledge of previous
     * moves.
     */

    protected double weight;
    protected Random generator;

    public GeneticStrategy(double n) {
        this.weight = n;
        this.generator = new Random();
    }

    /**
     * Mutate this genetic strategy by modifying its weight.
     */
    public void mutate() {
        boolean pm = generator.nextDouble() > 0.5;
        double val = generator.nextDouble() * 0.004;
        this.weight = pm && this.weight + val < 1 ? this.weight + val : this.weight - val > 0 ? this.weight - val : this.weight;
    }

    /**
     * Create a new mutated version of this genetic strategy.
     */
    public abstract GeneticStrategy mutateNew();

    /**
     * Return the weight of the GeneticStrategy.
     */
    public double getWeight() {
        return this.weight;
    }
}
