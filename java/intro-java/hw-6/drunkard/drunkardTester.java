import java.util.Scanner;

public class drunkardTester{
	public static void main(String... args){
		
		Scanner keyb = new Scanner(System.in);

		System.out.println("Please enter a starting avenue (integer): ");
		int ave = keyb.nextInt();

		System.out.println("Please enter the starting street (integer): ");
		int street = keyb.nextInt();

		// Initialize Drunkard object
		drunkard oZ = new drunkard(ave, street);

		// Move 100 itersections
		oZ.fastForward(100);

		// Get current location
		String location = oZ.getLocation();

		// Get dist from start
		int dist = oZ.howFar();

		System.out.println("Current loc: " + location + "\nIt is " +
		dist + " blocks from the starting point.");
	}

}
