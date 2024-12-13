package GameTheory.Strategies;

public class GeneticOneMove extends GeneticStrategy {

    private int Player1;
    private int Player2;
    private int totalScore; // Track total score for normalization

    // Separate scores for each factor
    private int Player1Score;
    private int Player2Score;
    private int weightScore;

    public GeneticOneMove(int Player1, int Player2, double weight) {
        super(weight);
        this.Player1 = Player1;
        this.Player2 = Player2;
        this.totalScore = 0;

        this.Player1Score = 0;
        this.Player2Score = 0;
        this.weightScore = 0;
    }

    @Override
    public int makeMove() {
        // Example logic for distinct behavior
        if (Player1 == 1) {
            return this.weight > 0.6 ? 1 : 0; // Cooperate if weight > 0.6
        } else if (Player1 == 2) {
            return Player2 % 2 == 0 ? 1 : 0; // Cooperate if Player2 is even
        } else if (Player1 == 3) {
            return Math.random() > 0.5 ? 1 : 0; // Random decision
        } else {
            return (this.weight + Player2 * 0.1) > 0.8 ? 1 : 0; // Player2 influences decision
        }
    }

    public void addScore(int points) {
        this.totalScore += points;

        // Distribute points between the factors (custom logic can be adjusted)
        this.Player1Score += points * 0.4; // 40% of the points attributed to Player1
        this.Player2Score += points * 0.3; // 30% to Player2
        this.weightScore += points * 0.3;  // 30% to weight
    }

    public double getNormalizedScore() {
        // Normalize score using a predefined factor (e.g., max possible points per game)
        double maxPossibleScore = 1000.0; // Adjust this as needed
        return this.totalScore / maxPossibleScore;
    }

    @Override
    public GeneticOneMove mutateNew() {
        // Mutate weight and optionally factors
        double mutation = generator.nextDouble() * 0.1; // Random mutation within ±0.1
        double newWeight = Math.min(1, Math.max(0, this.weight + mutation * (generator.nextBoolean() ? 1 : -1)));

        int newPlayer1 = Math.max(1, Math.min(4, Player1 + (generator.nextBoolean() ? 1 : -1)));
        int newPlayer2 = Math.max(1, Math.min(6, Player2 + (generator.nextBoolean() ? 1 : -1)));

        return new GeneticOneMove(newPlayer1, newPlayer2, newWeight);
    }

    @Override
    public String getStrategyName() {
        // Format the output to include individual factor scores
        return String.format(
                "GeneticOneMove(Player1=%d, Player2=%d, W=%.2f) NormScore=%.2f",
                Player1, Player2, weight, getNormalizedScore(), Player1Score, Player2Score, weightScore
        );
    }
}
