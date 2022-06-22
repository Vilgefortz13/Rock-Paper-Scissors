package com.company;


import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static int playerWins = 0, botWins = 0, draws = 0, totalGames = 0;

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Actions[] actions = Actions.values();
        System.out.print("| ");
        for (Actions a : actions) {
            System.out.print(a + " | ");
        }
        System.out.println();
        System.out.print("Select the sign you want to select by its number (1 - 3): ");
        int playerChoice = getNumber() - 1;

        while (playerChoice < 0 || playerChoice > 2) {
            System.out.print("Invalid value. Enter from 1 to 3: ");
            playerChoice = getNumber() - 1;
        }

        Actions player = actions[playerChoice];
        Actions playerBot = actions[playerBot()];

        totalGames++;

        if (player == Actions.ROCK) {
            if (playerBot == Actions.PAPER) {
                printActions(player, playerBot);
                System.out.println("You lose!");
                botWins++;
            } else if (playerBot == Actions.SCISSORS) {
                printActions(player, playerBot);
                System.out.println("You win!");
                playerWins++;
            } else {
                printActions(player, playerBot);
                System.out.println("Draw");
                draws++;
            }
        } else if (player == Actions.PAPER) {
            if (playerBot == Actions.PAPER) {
                printActions(player, playerBot);
                System.out.println("Draw");
                draws++;
            } else if (playerBot == Actions.SCISSORS) {
                printActions(player, playerBot);
                System.out.println("You lose!");
                botWins++;
            } else {
                printActions(player, playerBot);
                System.out.println("You win!");
                playerWins++;
            }
        } else {
            if (playerBot == Actions.PAPER) {
                printActions(player, playerBot);
                System.out.println("You win!");
                playerWins++;
            } else if (playerBot == Actions.SCISSORS) {
                printActions(player, playerBot);
                System.out.println("Draw");
                draws++;
            } else {
                printActions(player, playerBot);
                System.out.println("You lose!");
                botWins++;
            }
        }
    }

    private static int getNumber() {
        int value;
        while (true) {
            try {
                value = new Scanner(System.in).nextInt();
                return value;
            } catch (InputMismatchException e) {
                System.out.print("Invalid value. Try again: ");
            }
        }
    }

    private static int playerBot() {
        return new Random().nextInt(0, 3);
    }

    private static void printActions(Actions player, Actions bot) {
        System.out.println("Player: " + player);
        System.out.println("Bot: " + bot);
    }
}
