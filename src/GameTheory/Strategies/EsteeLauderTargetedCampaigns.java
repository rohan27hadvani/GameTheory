package GameTheory.Strategies;

public class EsteeLauderTargetedCampaigns extends Strategy {
    @Override
    public int makeMove() {
        // Targeted campaigns defect against cooperation but cooperate if the opponent defects consistently
        long totalDefects = opponentMoveHistory.stream().filter(m -> m == 0).count();
        return (totalDefects > (0.5 * opponentMoveHistory.size())) ? 1 : 0;
    }

    @Override
    public String getStrategyName() {
        return "EsteeLauderTargetedCampaigns";
    }
}
