import java.util.Random;
import java.util.Scanner;

public class Number_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        String plagain;

        do {
            int numGuess = ran.nextInt(100) + 1;
            int trial = 5;
            boolean GuessCorrectly = false;

            System.out.println("Welcome to the Number Game!");
            System.out.println("\nGuess a number between 1 and 100. \nYou have " + trial + " trials.");

            for (int i = 0; i < trial; i++) {
                System.out.print("\nEnter your guess: \t");
                int userGuess = sc.nextInt();

                if (userGuess == numGuess) {
                    System.out.println("\n\tCongratulations! You guessed the number correctly.");
                    GuessCorrectly = true;
                    break;
                } else if (userGuess < numGuess) {
                    System.out.println("\nThe number is greater than " + userGuess + ". \nTry again.");
                } else {
                    System.out.println("\nThe number is less than " + userGuess + ". \nTry again.");
                }
            }

            if (!GuessCorrectly) {
                System.out.println("\n\tYou have used all your trials. \n\tThe number was:\t " + numGuess);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            plagain = sc.next();

        } while (plagain.equalsIgnoreCase("yes"));

        System.out.println("\n\tThank you for playing the Number Game!");
        sc.close();
    }
}



   