import java.util.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class simpleIO{

	public static final void main(String[] args) throws FileNotFoundException{
	/*Initialize Scanner, File and Writer objects*/
	
	//Scanner object uses System.in as file pointer
	Scanner in = new Scanner(System.in);

	System.out.println("Type in an input file: ");
	//Grab user input (but does it count spaces?)
	String fileName = in.nextLine();
	//User input is used to create a new File object
	File input = new File(fileName);

	//Creates empty output file?
	PrintWriter output = new PrintWriter("Output.txt");

	in.close();
	output.close();
	}
}
