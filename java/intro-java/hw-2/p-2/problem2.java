/* Will calculate change based on purchase */
import java.util.Scanner;		// Scanner

public class problem2{

	public static void main(String[] args){

		Scanner keyb = new Scanner(System.in);
		System.out.println("Amount due (in pennies): ");

		String due = keyb.nextLine();
		int charge = Integer.parseInt(due);
		// Should add if/else to break if input not integer value

		System.out.println("Amount received (in pennies): ");
		String amountRecv = keyb.nextLine();
		int recv = Integer.parseInt(amountRecv);

		int ch = recv - charge;
		int qtrs = ch / 25;

		int QUARTER_VALUE = qtrs * 25;

		ch -= QUARTER_VALUE;
 
		int dimes = ch / 10;
		int DIME_VALUE = dimes * 10;
		
		ch -= DIME_VALUE; // Keep subtracting amounts...
		int nickels = ch / 5; // Get coins 

		int NICKEL_VALUE = nickels * 5;
		
		ch -= NICKEL_VALUE;
		int penny = ch / 1;

		if (ch > 0) {
			System.out.print("Your change will be " + qtrs
			+ " quarter(s) , " + dimes + " dime(s), " + nickels
			+ " nickel(s), " + penny + " pennie(s).");
		} else {
			System.out.println("Give me more money!");
		}
	}
}
