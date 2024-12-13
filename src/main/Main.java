package main;

import GameTheory.Strategies.*;
import GameTheory.Tournament;
import GameTheory.GeneticTournament;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Define strategies for Revlon
        Strategy revlonAggressive = new RevlonAggressive();
        Strategy revlonInnovative = new RevlonInnovative();
        Strategy revlonBroadDistribution = new RevlonBroadDistribution();

        // Define strategies for Estée Lauder
        Strategy esteelauderLuxury = new EsteeLauderLuxury();
        Strategy esteelauderSustainable = new EsteeLauderSustainable();
        Strategy esteelauderTargetedCampaigns = new EsteeLauderTargetedCampaigns();

        // Define the Simpleton strategy
        Strategy simpleton = new Simpleton();

        // Add all predefined strategies to the list
        List<Strategy> predefinedStrategies = Arrays.asList(
                revlonAggressive, revlonInnovative, revlonBroadDistribution,
                esteelauderLuxury, esteelauderSustainable, esteelauderTargetedCampaigns,
                simpleton
        );

        // Initialize the Tournament with predefined strategies
        Tournament tournament = new Tournament(predefinedStrategies);

        // Specify the number of tournament rounds
        int numRounds = 10;

        // Execute the tournament for predefined strategies
        System.out.println("Predefined Strategies Tournament:");
        Map<Strategy, Integer> results = tournament.executeTournamentRounds(numRounds);
        results.forEach((strategy, score) -> {
            System.out.println(strategy.getStrategyName() + ": " + score + " points");
        });

        System.out.println("---------------------------------------------------");

        // Define Genetic Strategies (24 combinations)
        List<GeneticStrategy> geneticStrategies = new ArrayList<>();
        for (int Player1 = 1; Player1 <= 4; Player1++) {
            for (int Player2 = 1; Player2 <= 6; Player2++) {
                geneticStrategies.add(new GeneticOneMove(Player1, Player2, Math.random()));
            }
        }

        // Initialize Genetic Tournament
        GeneticTournament geneticTournament = new GeneticTournament(geneticStrategies);

        // Execute the genetic tournament
        try {
            System.out.println("Genetic Strategies Tournament:");
            Map<GeneticStrategy, Integer> geneticResults = geneticTournament.executeGeneticTournamentRounds(numRounds);
            geneticResults.keySet().forEach(strategy -> {
                System.out.println(strategy.getStrategyName());
            });
        } catch (Exception e) {
            System.err.println("Error during genetic tournament: " + e.getMessage());
        }

        System.out.println("Tournament Completed.");
    }
}
