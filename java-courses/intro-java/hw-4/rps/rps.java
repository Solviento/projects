/* Low level simulation of Rock Paper Scissors */
import java.util.Scanner;				// Scanner
import java.util.Random;				// Rand

public class rps{

	static int user = 0;    // user initial score
	static int comp = 0;    // comp initial score
	static int FINISH = 5;  // Final score comparison
	static int ROCK = 0; 	// Val for getting rock
	static int SCIS = 2;	// Val for getting scis (paper is value of 1)

	/* Borrowed from stackOverflow */
	public static int ranNumberGenerator(int min, int max){

		Random r = new Random();		// New 'random' object created
		int num = r.nextInt(max-min);	// Generates number between min, max
		num += 1;						// Processing..
		num += min;						// Either 0, 1, 2 is produced
		// Please double check as to how this works
		return num;
	}
	public static void game(){

		Scanner keyb = new Scanner(System.in);
		System.out.println("Rock, Paper, Scissors:\n" + "Enter 0 for rock, " +
		"1 for paper, or 2 for scissors\n" + "Winner of 5 games wins");
		gameLoop(keyb);
	}
	public static void gameLoop(Scanner keyb){
		while(user < FINISH && comp < FINISH){
			System.out.println("Current scores\nComp: " + comp + "\nUser: " + user);
			int userIn = keyb.nextInt();
			int computer = ranNumberGenerator(ROCK, SCIS);
			System.out.println("You chose: " + user + " Comp chose: " + computer);
			// Paper beats Rock, Rock beats Scis, Scis beats Paper
			if (userIn == 0 && computer == 1){
				System.out.println("Comp schose paper. You lose this round.");
				comp++;
			}
			if (userIn == 0 && computer == 2) {
				System.out.println("Computer chose scissors. You win.");
				user++;
			}
			if (userIn == 1 && computer == 0) {
				System.out.println("Computer chose rock. You win.");
				user++;
			}
			if (userIn == 1 && computer == 2) {
				System.out.println("Computer chose scissors. You lose.");
				comp++;
			}
			if (userIn == 2 && computer == 0) {
				System.out.println("Computer chose rock. You lose.");
				comp++;
			}
			if (userIn == 2 && computer == 1) {
				System.out.println("Computer chose paper. You win.");
				user++;
			}
			if (userIn == computer){
				System.out.println("You and computer chose the same. Draw.");
			}
			// After analyzing this, we may also write up custom Rock, Paper object				// And hide ugly implementation details for future programs
		}
		if (user > comp){
			System.out.println("You won five total rounds!");
		}
		else{
			System.out.println("You lost five total rounds. Sorry");
		}
	}
	public static void main(String... args){
		game();
	}
}

