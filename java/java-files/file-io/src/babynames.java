import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* 
	Will display the most common baby names in the U.S.
	This information is taken from a 1990 survey.
*/

public class babynames{

	public static final int LIMIT = 50;

	public static void main(String[] args) throws FileNotFoundException{

		/* The way Scanner(File) works, first we create a new File 
		object using the txt file and insert that File object into
		a Scanner call so that a Scanner object can be made */
		Scanner in = new Scanner(new File("babynames.txt"));

		double boyTotal = 0;
		double girlTotal = 0;

		while( boyTotal < LIMIT || girlTotal < LIMIT){

		/* Grabs next entered integer from user input */
		int rank = in.nextInt();

		/*Notice no new line is added, this is due to aesthetic reasons */
		System.out.print(rank + " ");

		boyTotal = processName(in, boyTotal);
		girlTotal = processName(in, girlTotal);

		System.out.println(); /*New line displayed */

		}
	/* Always close file-io objects! */
	in.close();
	}

	/*
		Will read name information, prints the name is total attribute is
		greater or equal to 0. Will also adjust the overall total.
		Will return the overall total.
	*/
	
	public static double processName(Scanner in, double total){

		/* Will grab entire file input in the line, could be int, 
		str, char, etc */
		/* Double check if it also includes spaces */
		String name = in.next(); 
		/* We look for integers in the next available input, this is done
		since we know what the format of the file input looks like. Not all
		files should be processed this way! */
		int count = in.nextInt();
		double percent = in.nextDouble();

		if (total < LIMIT) {
			System.out.print(name + " ");
		}
		total = total + percent;
		/* Returns percentage of name occurence in file */
		return total;
	}
}
