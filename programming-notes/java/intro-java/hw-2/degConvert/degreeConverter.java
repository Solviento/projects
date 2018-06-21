/* Will convert degrees to celsius, vice versa */
import java.util.Scanner;		// Scanner

public class degreeConverter{

	public static void main(String... args){

		Scanner keyb = new Scanner(System.in);	// Keyboard -> Scanner object

		System.out.println(
			"Enter 1 to convert from Cels to Farenh, Enter 2 to convert" +
			" from Farenh to Cels.");

		String input = keyb.nextLine();			// Grab next line of keyb input
		int convert = Integer.parseInt(input);

		switch(convert){

			case 1:
				System.out.println("Enter val: ");
				String c = keyb.nextLine();
				double cel = Double.parseDouble(c);
				double FRAC = (9.0/5.0);
				double faren = FRAC * cel + 32;
				System.out.printf("Conversion to fahrenheit: %.2f", faren);
				break;
			case 2:
				 System.out.println("Enter val: ");
				 String f = keyb.nextLine();
				 double far = Double.parseDouble(f);
	             double FRAC2 = (5.0/9.0);
                 double celsius = FRAC2 * (far - 32);
				 System.out.printf("Conversion to celsius: %.2f", celsius);
				 break;
			default:
				System.out.println("Wrong input");
				break;
		}
	}
}
