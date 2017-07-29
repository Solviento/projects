
//Jason Perez
//UNI: jp3476

import java.util.Scanner;

public class Problem1 {

	public static final void main(String... args) {

		ExpressionTree test = new ExpressionTree();
		Scanner in = new Scanner(System.in);

		System.out.println("Enter postfix expression: ");
		String exp = in.nextLine();

		test.Tree(exp);

		System.out.println("Prefix: " + test.prefix());
		System.out.println("Postfix: " + test.postfix());
		System.out.println("Infix:" + test.infix());
		System.out.println("Expression evaluates to: " + test.eval());

		// Sample Post Fix Expression: 34 2 - 5 *
		// Any other expressions will give an error
	}
}