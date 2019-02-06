import java.util.Scanner;

public class Prime {

	// Will calculate prime or not prime of an integer
	// @param Will take in an integer, will return a boolean
	public static boolean checkPrime(int number) 
	{
		boolean prime = true;

		// slow and ineffient way to calculate if number is prime
		for (int i = 2; i <= number / 2; i++) { 
			if (number % i == 0) {              
				prime = false;
				break; 
			}
		}
		return prime;

	}

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Type an integer value: ");
		int number = in.nextInt();
		boolean primeCheck = checkPrime(number); // checks for prime boolean

		if (primeCheck == false) {
			System.out.println(number + " is not prime.");
		}
		if (primeCheck == true) {
			System.out.println(number + " is prime.");
		}
	}
}