import java.util.Scanner;			// Scanner

public class problem1 {

	public static void main(String[] args){

		System.out.print("Please enter a year: ");

		Scanner keyboard = new Scanner(System.in);	// Takes keyboard as input

		String year = keyboard.nextLine();			// Takes user input once 'Enter' is hit
		
		int y = Integer.parseInt(year);			// Converts string input to int
		// Note: If input not a convertible string, program will fail at runtime

		int a = y % 19;
		int b = y / 100;
		int c = y % 100;
		int d = b / 4;
		int e = b % 4;
		int g = (8 * b + 13) / 25;
		int h = (19 * a + b - d - g + 15) % 30;
		int j = c / 4;
		int k = c % 4;
		int m = (a + 11 * h) / 319;
		int r = (2 * e + 2 * j - k - h + m + 32) % 7;
		int n = (h - m + r + 90) / 25;
		int p = (h - m + r + n + 19) % 32;

		String month = "";

		switch(n){

			case 1: month += "January"; break;
			case 2: month += "February"; break;
			case 3: month += "March"; break;
			case 4: month += "April"; break;
			case 5: month += "May";   break;
			case 6: month += "June";  break;
			default: break;
		}

		System.out.println("Easter Sunday takes place on " + month + ", " + p);

	}
}
