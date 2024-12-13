package main;

import GameTheory.Strategies.*;
import GameTheory.Tournament;
import GameTheory.GeneticTournament;


import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int player1score;
        int player2score;
       // Strategy defect = new AlwaysDefect();
       // Strategy cooperate = new AlwaysCooperate();
        Strategy Expansion =  new ExpansionOfUberEats();
        Strategy SurgePricing =  new AIDrivenSurgePricing();
        Strategy Investment =  new InvestmentinAutonomusVehicles();
        Strategy Sustainability =  new SustainabilityandEVAdoption();
        Strategy Partnerships = new Partnershipswithpublictransportationnetworks();
        Strategy Incentives = new Driverincentiveschemes();
        
        

        // Create TitForTat strategy
       Strategy titForTat = new TitForTat();
       
    
       
        // Create a list of all strategies
        //Strategy geneticOneMove = new GeneticOneMove();
        
        List<Strategy> allStrategies = new ArrayList<>(Arrays.asList(
                 Expansion,SurgePricing,
                Investment,Sustainability,Partnerships,
                Incentives,titForTat
        ));

        // Create a Tournament for all strategies
        Tournament tournament = new Tournament(allStrategies);

        // Specify the number of rounds for each iteration
        int numRounds = 10;

        // Run the tournament for all strategies
        System.out.println("Results:");
        for (int iteration = 0; iteration < 10; iteration++) {
            

            // Execute the tournament rounds
            HashMap<Strategy, Integer> results1 = tournament.executeTournamentRounds(numRounds);

            System.out.println("Iteration " + iteration + " Results:");
            for (Map.Entry<Strategy, Integer> entry : results1.entrySet()) {
                System.out.println(entry.getKey().getStrategyName() + ": " + entry.getValue() + " points");
                System.out.println("Player 1 score is: " + entry.getKey().getPlayer1Score());
                System.out.println("Player 2 score is: " + entry.getKey().getPlayer2Score());
            }
           
            System.out.println("-----------------------------------------------------------------------------------");
        }
        System.out.println();
        
        System.out.println("Starting Genetic Algorithm in Tournament");
        List<GeneticStrategy> strategiesForGeneticAlgorithm = new ArrayList<>();
        for (double i = 0.5; i < 1; i += 0.005) {
            strategiesForGeneticAlgorithm.add(new GeneticOneMove(i));
        }

        GeneticTournament geneticTournament = new GeneticTournament(strategiesForGeneticAlgorithm);

        HashMap<GeneticStrategy, Integer> results2 = geneticTournament.executeGeneticTournamentRounds(10);

        Object[] gStrategies = geneticTournament.tournamentPoints.keySet().toArray();
        System.out.println("Genetic Algorithm Results:");

        for (int i = 0; i < 10; i++) {
            System.out.println("Iteration " + i + " Results:");
            for (int j = i; j < 10; j++) {
                if (i < 9) {
                    System.out.println("Genetic One Move Score: " + geneticTournament.tournamentPoints.getOrDefault(gStrategies[j], 1));
                    for (Map.Entry<GeneticStrategy, Integer> entry : results2.entrySet()) {
                        System.out.println(entry.getKey().getStrategyName() + ": " + entry.getValue() + " points");
                        System.out.println("Player 1 score is: " + entry.getKey().getPlayer1Score());
                        System.out.println("Player 2 score is: " + entry.getKey().getPlayer2Score());
                    }
                    
                } else {
                    System.out.println("Final Winning Score of Genetic One Move: " + geneticTournament.tournamentPoints.getOrDefault(gStrategies[j], 1));
                    for (Map.Entry<GeneticStrategy, Integer> entry : results2.entrySet()) {
                        System.out.println(entry.getKey().getStrategyName() + ": " + entry.getValue() + " points");
                        System.out.println("Player 1 score is: " + entry.getKey().getPlayer1Score());
                        System.out.println("Player 2 score is: " + entry.getKey().getPlayer2Score());
                    }
                }
            }
            System.out.println("-----------------------------------------------------------------------------------");
        }
        //-------------------------------------------------------------

        
    }

    
}


/**
package main;

import GameTheory.Strategies.*;
import GameTheory.Tournament;
import GameTheory.GeneticTournament;

import java.io.IOException;
import java.util.*;**/
/**
public class Main {

    public static void main(String[] args) throws IOException {
        int player1score;
        int player2score;

        // Initialize strategies
        Strategy LowCost = new AlwaysLowCost();
        Strategy Loyalty = new AlwaysLoyaltyPrograms();
        Strategy PremiumQuality = new AlwaysPremiumQuality();
        Strategy Promotions = new AlwaysPromotions();
        Strategy SustainabilityIntiatives = new AlwaysSustainabilityInitiatives();
        Strategy ProductVariety = new Product_Variety();

        // Create a list of all strategies
        List<Strategy> allStrategies = new ArrayList<>(Arrays.asList(
                LowCost, Loyalty, PremiumQuality, Promotions, SustainabilityIntiatives, ProductVariety
        ));

        // Create a Tournament for all strategies
        Tournament tournament = new Tournament(allStrategies);

        // Specify the number of rounds for each iteration
        int numRounds = 10;

        // Run the tournament for all strategies
        System.out.println("Results:");
        for (int iteration = 0; iteration < 10; iteration++) {
            // Execute the tournament rounds
            HashMap<Strategy, Integer> results1 = tournament.executeTournamentRounds(numRounds);

            System.out.println("Iteration " + iteration + " Results:");
            for (Map.Entry<Strategy, Integer> entry : results1.entrySet()) {
                System.out.println(entry.getKey().getStrategyName() + ": " + entry.getValue() + " points");
                System.out.println("Player 1 score is: " + entry.getKey().getPlayer1Score());
                System.out.println("Player 2 score is: " + entry.getKey().getPlayer2Score());
            }

            System.out.println("-----------------------------------------------------------------------------------");
        }
        System.out.println();

        // Genetic Algorithm Tournament
        System.out.println("Starting Genetic Algorithm in Tournament");
        List<GeneticStrategy> strategiesForGeneticAlgorithm = new ArrayList<>();
        // Uncomment and populate with appropriate strategies if necessary
        // for (double i = 0.5; i < 1; i += 0.005) {
        //     strategiesForGeneticAlgorithm.add(new GeneticOneMove(i));
        // }

        GeneticTournament geneticTournament = new GeneticTournament(strategiesForGeneticAlgorithm);

        HashMap<GeneticStrategy, Integer> results2 = geneticTournament.executeGeneticTournamentRounds(10);

        Object[] gStrategies = geneticTournament.tournamentPoints.keySet().toArray();
        if (gStrategies.length == 0) {
            System.out.println("No genetic strategies available in the tournament.");
        } else {
            for (int i = 0; i < 10; i++) {
                System.out.println("Iteration " + i + " Results:");
                for (int j = 0; j < gStrategies.length; j++) {
                    System.out.println("Genetic One Move Score: " + geneticTournament.tournamentPoints.getOrDefault(gStrategies[j], 1));
                    for (Map.Entry<GeneticStrategy, Integer> entry : results2.entrySet()) {
                        System.out.println(entry.getKey().getStrategyName() + ": " + entry.getValue() + " points");
                        System.out.println("Player 1 score is: " + entry.getKey().getPlayer1Score());
                        System.out.println("Player 2 score is: " + entry.getKey().getPlayer2Score());
                    }
                }
                System.out.println("-----------------------------------------------------------------------------------");
            }
        }
    }
}
* */
