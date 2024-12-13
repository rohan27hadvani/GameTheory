package GameTheory;

import GameTheory.Strategies.Strategy;

import java.util.*;

public class Tournament {

    private HashMap<Strategy, Integer> points;

    public Tournament(List<Strategy> strategies) {
        this.points = new HashMap<>();
        strategies.forEach(s -> this.points.put(s, 0));
    }

    public HashMap<Strategy, Integer> executeTournamentRounds(int numRounds) {
        for (int i = 0; i < numRounds; i++) {
            addNewPoints(tournamentRound(10));
        }
        return this.points;
    }

    private HashMap<Strategy, Integer> tournamentRound(int n) {
        HashMap<Strategy, Integer> tournamentPoints = new HashMap<>();
        List<Strategy> strategyList = new ArrayList<>(this.points.keySet());
        Collections.shuffle(strategyList); // Shuffle for randomness
    
        for (int i = 0; i < strategyList.size(); i++) {
            for (int j = i + 1; j < strategyList.size(); j++) {
                Game g = new Game(strategyList.get(i), strategyList.get(j));
                List<Integer> gameOutcome = g.executeGame(n);
    
                int s1PrevPts = tournamentPoints.getOrDefault(strategyList.get(i), 0);
                int s2PrevPts = tournamentPoints.getOrDefault(strategyList.get(j), 0);
    
                tournamentPoints.put(strategyList.get(i), s1PrevPts + gameOutcome.get(0));
                tournamentPoints.put(strategyList.get(j), s2PrevPts + gameOutcome.get(1));
            }
        }
        return tournamentPoints;
    }
    

    private void addNewPoints(HashMap<Strategy, Integer> newPoints) {
        for (Strategy s : newPoints.keySet()) {
            int prevPts = this.points.getOrDefault(s, 0);
            this.points.put(s, prevPts + newPoints.get(s));
        }
    }
}
