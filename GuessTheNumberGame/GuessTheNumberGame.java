import java.util.*;
public class GuessTheNumberGame{
	private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS_EASY = 10;
    private static final int MAX_ATTEMPTS_MEDIUM = 6;
    private static final int MAX_ATTEMPTS_HARD = 4;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Welcome to Game Guess the Number!");

        while(true) {
	        // Choose difficulty level
	        System.out.println("Choose  Your difficulty level: easy, medium, or hard?");
	        String difficultyLevelString = sc.next().toLowerCase();
	        int difficultyLevel = 0;
	        if (difficultyLevelString.equals("easy")) {
	            difficultyLevel = 1;
	        } else if (difficultyLevelString.equals("medium")) {
	            difficultyLevel = 2;
	        } else if (difficultyLevelString.equals("hard")) {
	            difficultyLevel = 3;
	        } else {
	            throw new IllegalArgumentException("Invalid difficulty level");
	        }

	        // Set max attempts based on difficulty level
	        int maxAttempts = 0;
	        switch (difficultyLevel) {
	            case 1:
	                maxAttempts = MAX_ATTEMPTS_EASY;
	                break;
	            case 2:
	                maxAttempts = MAX_ATTEMPTS_MEDIUM;
	                break;
	            case 3:
	                maxAttempts = MAX_ATTEMPTS_HARD;
	                break;
	            default:
	                throw new IllegalArgumentException("Invalid difficulty level");
	        }

        // Play the game 
	        int targetNumber = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
	        int attempts = 0;
	        int score = 0;
	        int totalscore=0;

	        System.out.println("I'm thinking of a number between " + MIN_RANGE + " and " + MAX_RANGE + ".");

	        while (attempts < maxAttempts) {
	            System.out.print("Enter your guess: ");
	            int userGuess = sc.nextInt();
	            attempts++;

	            if (userGuess == targetNumber) {
	                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
	                score++;
	                break;
	            } else if (userGuess < targetNumber) {
	                System.out.println("Try a higher number than the guess number.");
	            } else {
	                System.out.println("Try a lower number than the guess number.");
	            }

	            if (attempts == maxAttempts) {
	                System.out.println("Sorry, you've run out of attempts. The number was " + targetNumber + ".");
	            }
	        }

			 totalscore=totalscore+score;
	        System.out.print("Do you want to play again? (Y/N): ");
            String playAgain = sc.next().toUpperCase();
            if (!playAgain.equals("Y")) {
                System.out.println("Thanks for playing! Your final score for all the rounds is: " + totalscore);
                break;
            }

        }
        sc.close();

}
}