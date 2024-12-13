package GameTheory;

import GameTheory.Strategies.GeneticOneMove;
import GameTheory.Strategies.GeneticStrategy;

import java.util.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class GeneticTournament {

    public HashMap<GeneticStrategy, Integer> tournamentPoints = new HashMap<>();
    private HashMap<GeneticStrategy, Integer> points;

    public GeneticTournament(List<GeneticStrategy> strategies) {
        this.points = new HashMap<>();
        strategies.forEach(s -> this.points.put(s, 0));
    }

    public HashMap<GeneticStrategy, Integer> executeGeneticTournamentRounds(int numRounds) throws IOException {
        HashMap<GeneticStrategy, Integer> finalResults = new HashMap<>();
        FileWriter fileWriter = new FileWriter("geneticRes.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);

        for (int i = 0; i < numRounds; i++) {
            addNewPoints(tournamentRound(100));

            ArrayList<Map.Entry<GeneticStrategy, Integer>> sortedEntries = sortEntries(this.points.entrySet());

            this.points.forEach((strategy, score) -> printWriter.printf("%f %d\n", strategy.getWeight(), score));
            printWriter.printf("-------\n");

            List<Map.Entry<GeneticStrategy, Integer>> toRemove = sortedEntries.subList(sortedEntries.size() / 2, sortedEntries.size());
            toRemove.forEach(entry -> this.points.remove(entry.getKey()));

            if (i == numRounds - 1) {
                finalResults = new HashMap<>(this.points);
            }

            HashMap<GeneticStrategy, Integer> newStrategies = new HashMap<>();
            for (GeneticStrategy strategy : this.points.keySet()) {
                GeneticStrategy mutatedStrategy = strategy.mutateNew();
                newStrategies.put(mutatedStrategy, 0);
            }

            this.points.forEach((strategy, score) -> {
                strategy.mutate();
                this.points.put(strategy, 0);
            });

            this.points.putAll(newStrategies);
            printWriter.printf("-------\n");
        }

        printWriter.close();
        return finalResults;
    }

    private HashMap<GeneticStrategy, Integer> tournamentRound(int n) {
        HashMap<GeneticStrategy, Integer> roundResults = new HashMap<>();
        Object[] strategies = this.points.keySet().toArray();

        for (int i = 0; i < strategies.length; i++) {
            for (int j = i + 1; j < strategies.length; j++) {
                Game game = new Game((GeneticStrategy) strategies[i], (GeneticStrategy) strategies[j]);
                List<Integer> gameOutcome = game.executeGame(n);

                int s1PrevPts = roundResults.getOrDefault(strategies[i], 0);
                int s2PrevPts = roundResults.getOrDefault(strategies[j], 0);

                roundResults.put((GeneticStrategy) strategies[i], s1PrevPts + gameOutcome.get(0));
                roundResults.put((GeneticStrategy) strategies[j], s2PrevPts + gameOutcome.get(1));
            }
        }
        return roundResults;
    }

    private void addNewPoints(HashMap<GeneticStrategy, Integer> newPoints) {
    for (GeneticStrategy strategy : newPoints.keySet()) {
        ((GeneticOneMove) strategy).addScore(newPoints.get(strategy)); // Add score directly to the strategy
    }
}


    public ArrayList<Map.Entry<GeneticStrategy, Integer>> sortEntries(Set<Map.Entry<GeneticStrategy, Integer>> entrySet) {
        ArrayList<Map.Entry<GeneticStrategy, Integer>> sortedEntries = new ArrayList<>(entrySet);
        sortedEntries.sort((entry1, entry2) -> entry2.getValue() - entry1.getValue());
        return sortedEntries;
    }
}
