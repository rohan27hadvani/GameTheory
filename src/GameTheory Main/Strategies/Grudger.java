package GameTheory.Strategies;

public class Grudger extends Strategy {

    /**
     * Strategy from the Evolution of Trust (https://ncase.me/trust/)
     *
     * Player cooperates until the opponent cheats; then they always cheat.
     */

    private boolean opponentCheated;

    public Grudger() {
        super();
        opponentCheated = false;
    }

    @Override
    public int makeMove() {
        return opponentCheated ? 0 : 1;
    }

    @Override
    public void addOpponentMove(int opponentMove) {
        if (!opponentCheated && opponentMove == 0) {
            opponentCheated = true;
        }
        super.addOpponentMove(opponentMove);
    }

    @Override
    public void clearStrategy() {
        super.clearStrategy();
        opponentCheated = false;
    }

    @Override
    public String getStrategyName() {
        return "Grudger";
    }
}
