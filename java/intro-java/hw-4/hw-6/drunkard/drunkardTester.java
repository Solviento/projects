import java.util.Scanner;

public class drunkardTester{
	public static void main(String... args){
		
		Scanner keyb = new Scanner(System.in);

		System.out.println("Please enter a starting avenue (integer): ");
		int ave = input.nextInt();

		System.out.println("Please enter the starting street (integer): ");
		int street = input.nextInt();

		// Initialize Drunkard object
		Drunkard oZ = new Drunkard(ave, street);

		// Move 100 itersections
		oZ.fastForward(100);

		// Get current location
		String location = oZ.getLocation();

		// Get dist from start
		int dist = oZ.howFar();

		System.out.println("Current loc: " + location + "\nIt is " +
		distance + " blocks from the starting point.");
	}

}
