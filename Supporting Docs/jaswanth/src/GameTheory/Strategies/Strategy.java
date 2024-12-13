package GameTheory.Strategies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Strategy {
    protected List<Integer> opponentMoveHistory;
    protected List<Integer> opponentMoveHistoryPlayer1 = new ArrayList(0);
    protected List<Integer> opponentMoveHistoryPlayer2 = new ArrayList(0);
    protected List<Integer> outcomes;
    protected int player1_points;
    protected int player2_points;
    
    /**
    protected static final int[][] payoffMatrix = {
        {24, 24, 30, 60, 0, 36},
        {30, 0, 18, 18, 10, 36},
        {36, 0, 60, 0, 6, 6}
    };
    * */

    public Strategy() {
        this.opponentMoveHistory = new java.util.ArrayList<>();
        this.opponentMoveHistoryPlayer1 = new java.util.ArrayList<>();
        this.opponentMoveHistoryPlayer2 = new java.util.ArrayList<>();
        this.outcomes = new java.util.ArrayList<>();
        
    }

    public abstract int makeMove(boolean player);

    public String getStrategyName() {
        return this.getClass().getSimpleName();
    }

    public void addOpponentMove(int opponentMove) {
        this.opponentMoveHistory.add(opponentMove);
    }
    
public void addOpponentMovePlayer1(int opponentMovePlayer1) {
        this.opponentMoveHistoryPlayer1.add(opponentMovePlayer1);
    }
    public void addOpponentMovePlayer2(int opponentMovePlayer2) {
        this.opponentMoveHistoryPlayer2.add(opponentMovePlayer2);
    }

    public int getPoints() {
        return this.outcomes.stream().reduce(0, (a, b) -> a + b);
    }
    
    public void setPlayer1Score(int a){
        this.player1_points += a;
    }
    
    public void setPlayer2Score(int a){
        this.player2_points += a;
    }
    
    public int getPlayer1Score(){
        return this.player1_points;
    }
    
    public int getPlayer2Score(){
        return this.player2_points;
    }

    public void clearStrategy() {
        this.outcomes.clear();
        this.opponentMoveHistory.clear();
        this.opponentMoveHistoryPlayer1.clear();
        this.opponentMoveHistoryPlayer2.clear();
        
    }
    

    public void addOutcome(int outcome) {
        this.outcomes.add(outcome);
    }

    public List<Integer> getOutcomes() {
        return Collections.unmodifiableList(outcomes);
    }
    
}
