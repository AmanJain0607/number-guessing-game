import java.util.Scanner;

public class GuessingGames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean playAgain = true;
        boolean newGame = true;
        int random=0;
        int totalAttempts = 0;

        while (playAgain) {
            if (newGame) {
                random = (int) (Math.random() * 100) + 1;
                totalAttempts = 0;
            }

            int attempts = 0;
            int maximumChances = 5;
            boolean guessed = false;

            System.out.println("Guess a number between 1 to 100. You have " + maximumChances + " attempts.");

            while (attempts < maximumChances && !guessed) {
                System.out.print("Enter your guess (or type 'no'/'exit' to quit): ");

                String input = sc.next();

                switch (input.toLowerCase()) {
                    case "no":
                    case "exit":
                        System.out.println("I wished you would've completed your attempts at least. Anyways, your score is " + attempts + ". Total attempts made: " + totalAttempts);
                        playAgain = false;
                        break;

                    default:
                        try {
                            int guess = Integer.parseInt(input);
                            attempts++;
                            totalAttempts++;

                            if (guess == random) {
                                System.out.println("You've guessed it, congrats!");
                                guessed = true;
                                System.out.println("Total attempts made: " + totalAttempts);
                                System.out.print("Do you want to start a new game or exit? (new/no): ");
                                String choice = sc.next().toLowerCase();
                                switch (choice) {
                                    case "new":
                                        newGame = true;
                                        break;
                                    case "no":
                                        playAgain = false;
                                        break;
                                    default:
                                        System.out.println("Invalid choice. Exiting game.");
                                        playAgain = false;
                                }
                                break;
                            } else if (guess < random) {
                                System.out.println("Too low, try again.");
                            } else {
                                System.out.println("Too high, try again.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a number or type 'no'/'exit' to quit.");
                        }
                }
            }

            if (!guessed && !playAgain) {
                System.out.println("YOU LOSE.");
            }

            if (!guessed && playAgain) {
                System.out.print("Do you want to play again with the same number or start a new game or exit game? (same/new/no): ");
                String choice = sc.next().toLowerCase();

                switch (choice) {
                    case "same":
                        newGame = false;
                        break;
                    case "new":
                        newGame = true;
                        totalAttempts = 0;
                        break;
                    case "no":
                        playAgain = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Exiting game.");
                        playAgain = false;
                }
            }
        }

        System.out.println("Thanks for playing!");
        sc.close();
    }
}
