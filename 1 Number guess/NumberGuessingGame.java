import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        playMultipleRounds();
    }

    public static void playGame() {
        int lowerLimit = 1;
        int upperLimit = 100;
        int maxAttempts = 5;
        Random random = new Random();
        int randomNumber = random.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
        int attempts = 0;

        System.out.println("Welcome to the Number Guessing Game");
        System.out.printf("I'm thinking of a number between %d and %d.%n", lowerLimit, upperLimit);
        System.out.printf("You have %d attempts to guess the number.%n", maxAttempts);

        Scanner scanner = new Scanner(System.in);
        while (attempts < maxAttempts) {
            attempts++;
            System.out.printf("Attempt %d: Enter your guess: ", attempts);
            int userGuess = scanner.nextInt();

            if (userGuess == randomNumber) {
                System.out.printf("Congratulations! You guessed the correct number %d in %d attempts.%n", randomNumber, attempts);
                return;
            } else if (userGuess < randomNumber) {
                System.out.println("Too low! Try guessing a higher number.");
            } else {
                System.out.println("Too high! Try guessing a lower number.");
            }
        }

        System.out.printf("Sorry, you couldn't guess the number. It was %d.%n", randomNumber);
    }

    public static boolean playAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to play again? (yes/no): ");
        String choice = scanner.nextLine();
        return choice.equalsIgnoreCase("yes");
    }

    public static void playMultipleRounds() {
        int roundsPlayed = 0;
        int roundsWon = 0;
        int maxRounds = 3;

        do {
            roundsPlayed++;
            System.out.printf("%nRound %d:%n", roundsPlayed);
            playGame();

            System.out.print("Press Enter to continue...");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();

            if (roundsWon == roundsPlayed - 1) {
                roundsWon++;
            }
        } while (roundsPlayed < maxRounds && playAgain());

        double winPercentage = (double) roundsWon / roundsPlayed * 100;
        System.out.printf("%nGame Over!%nYou played %d rounds.%n", roundsPlayed);
        System.out.printf("You won %d out of %d rounds (%.2f%%).%n", roundsWon, roundsPlayed, winPercentage);
    }
}
