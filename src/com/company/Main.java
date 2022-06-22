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
        System.out.print("""
                Select the game mode
                    Simple - 1
                    Complicated - 2:\040""");

        int gameMode = getNumber();

        while (gameMode < 1 || gameMode > 2) {
            System.out.print("Invalid value! Please enter 1 or 2: ");
            gameMode = getNumber();
        }
        System.out.println();

        if (gameMode == 1) {
            simpleMode();
        } else {
            complicatedMode();
        }
    }

    private static void simpleMode() {
        Actions[] actions = new Actions[3];
        actions[0] = Actions.ROCK;
        actions[1] = Actions.PAPER;
        actions[2] = Actions.SCISSORS;
        while (true) {
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

            System.out.print("Do you want to complete the game? (y/n): ");
            String endGame = getString(new Scanner(System.in)).toLowerCase();

            while (!endGame.equals("y") && !endGame.equals("n")) {
                System.out.print("Please enter 'y' or 'n': ");
                endGame = getString(new Scanner(System.in)).toLowerCase();
            }
            System.out.println();

            if (endGame.equals("y")) {
                break;
            }
        }

        double winPercentage = (double) playerWins / totalGames * 100;
        System.out.printf("""
                        +-----------------------------------------------------------+
                        |  WINS  |  LOSES  |  DRAWS  | TOTAL GAMES | WIN PERCENTAGE |
                        |--------+---------+---------+-------------+----------------|
                        |  %4d  |  %5d  |  %5d  | %11d | %14.2f |
                        +-----------------------------------------------------------+""",
                playerWins, botWins, draws, totalGames, winPercentage);
    }

    private static void complicatedMode() {
        Actions[] actions = Actions.values();
        while (true) {
            System.out.print("| ");
            for (Actions a : actions) {
                System.out.print(a + " | ");
            }
            System.out.println();

            System.out.print("Select the sign you want to select by its number (1 - 5): ");
            int playerChoice = getNumber() - 1;

            while (playerChoice < 0 || playerChoice > 4) {
                System.out.print("Invalid value. Enter from 1 to 3: ");
                playerChoice = getNumber() - 1;
            }

            Actions player = actions[playerChoice];
            Actions playerBot = actions[playerBot()];

            totalGames++;

            if (player == Actions.ROCK) {
                if (playerBot == Actions.PAPER || playerBot == Actions.SPOCK) {
                    printActions(player, playerBot);
                    System.out.println("You lose!");
                    botWins++;
                } else if (playerBot == Actions.SCISSORS || playerBot == Actions.LIZARD) {
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
                } else if (playerBot == Actions.SCISSORS || playerBot == Actions.LIZARD) {
                    printActions(player, playerBot);
                    System.out.println("You lose!");
                    botWins++;
                } else {
                    printActions(player, playerBot);
                    System.out.println("You win!");
                    playerWins++;
                }
            } else if (player == Actions.SCISSORS) {
                if (playerBot == Actions.PAPER || playerBot == Actions.LIZARD) {
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
            } else if (player == Actions.LIZARD) {
                if (playerBot == Actions.SPOCK || playerBot == Actions.PAPER) {
                    printActions(player, playerBot);
                    System.out.println("You win!");
                    playerWins++;
                } else if (playerBot == Actions.ROCK || playerBot == Actions.SCISSORS) {
                    printActions(player, playerBot);
                    System.out.println("You lose!");
                    botWins++;
                } else {
                    printActions(player, playerBot);
                    System.out.println("Draw");
                    draws++;
                }
            } else {
                if (playerBot == Actions.SCISSORS || playerBot == Actions.ROCK) {
                    printActions(player, playerBot);
                    System.out.println("You win!");
                    playerWins++;
                } else if (playerBot == Actions.PAPER || playerBot == Actions.LIZARD) {
                    printActions(player, playerBot);
                    System.out.println("You lose!");
                    botWins++;
                } else {
                    printActions(player, playerBot);
                    System.out.println("Draw");
                    draws++;
                }
            }

            System.out.print("Do you want to complete the game? (y/n): ");
            String endGame = getString(new Scanner(System.in)).toLowerCase();

            while (!endGame.equals("y") && !endGame.equals("n")) {
                System.out.print("Please enter 'y' or 'n': ");
                endGame = getString(new Scanner(System.in)).toLowerCase();
            }
            System.out.println();

            if (endGame.equals("y")) {
                break;
            }
        }
        double winPercentage = (double) playerWins / totalGames * 100;
        System.out.printf("""
                        +-----------------------------------------------------------+
                        |  WINS  |  LOSES  |  DRAWS  | TOTAL GAMES | WIN PERCENTAGE |
                        |--------+---------+---------+-------------+----------------|
                        |  %4d  |  %5d  |  %5d  | %11d | %14.2f |
                        +-----------------------------------------------------------+""",
                playerWins, botWins, draws, totalGames, winPercentage);
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

    private static String getString(Scanner sc) {
        String str = "";
        while (sc.hasNextLine()) {
            try {
                str += sc.next("[a-zA-Z]+");
                break;
            } catch (InputMismatchException e) {
                System.out.print("Invalid value. Try again: ");
                sc.nextLine();
            }
        }

        return str;
    }
}
