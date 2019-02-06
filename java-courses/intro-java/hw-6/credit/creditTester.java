import java.util.Scanner;

public class creditTester {
    public static void main(String[] args) {
	    System.out.println("Please enter an 12-digit number.");
		Scanner scanner = new Scanner(System.in);
		String creditCardNumber = scanner.next();
		if (creditCardNumber.length() != 12) {
		    System.out.println("That was not an 12-digit number!");
		    return;
		}
		credit card = new credit(creditCardNumber);
		card.check();
		if (card.isValid()) {
			System.out.println("Valid"); // when isValid returns TRUE
		} 
		else {
		    int code = card.getErrorCode();
		    System.out.println("Oops! That's an invalid number.");
		    System.out.println("The error code was: " + code); 
		}
    }
}
