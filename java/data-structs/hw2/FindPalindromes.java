/* Jason
Programming Problem #1
Data Structures - Blaer
*/

import java.util.NoSuchElementException;// File element not valid (binary, exe, etc)
import java.util.Scanner;				// Scanner (keyboard)
import java.io.*;						// IOException
import java.util.*;

/* What does it do? Well, it finds palindromes
in a text file, */
public class FindPalindromes extends MyStack {
							// What does extends mean? Simply put,
							// extends is used for extension of a 
							// base class behavior
		public static void main (String... args){

			boolean verifyFile = false;

			while (!verifyFile){
				try{
					readFile(args[0]);
					verifyFile = true;
					// File verified. Program executed.

				}catch(FileNotFoundException exception){
						// Catches exception if input file not in system directory]
						System.out.println("Failure. Input file not found in system.");
						break;				
				}catch(NoSuchElementException exception){
					System.out.println("Failure. File contents invalid.");
					break;
				}catch(IOException exception){
					exception.printStackTrace();
					// Occurs when input IO stream gets disconnected
					// Not good exception handling behavior. Better methods available
					break;
				}
			}
		}

		/* Will take name of a text file (as String) and operate on it */
		public static void readFile(String name) throws IOException{
			
			File input = new File(name);		// Make new File object w name as its input parameter
			Scanner in = new Scanner(input);	// Make new Scanner object w input as its input
			// You can now parse through the input text file!

			String readLine;		// Store each read line (lol why is there two kinds of read?)
			String strippedLine;	// Use parseString function to strip the readLine String
			// Young programmer Jason did not know how to minimize his Strings, sadly.

			while (in.hasNextLine()){
				readLine = in.nextLine();				// Standard scanner read function
				strippedLine = parseString(readLine);
				// parseString will strip punctuation from readLine

				boolean verifyPalindrome = testPalin(strippedLine);

				if (verifyPalindrome){
					System.out.println(readLine);
					// Outputs found palindrome
				}
			}
			in.close();	// Always close your file objects!
		}
		
		/* Will remove punctuation from a String */
		public static String parseString(String line){
			String stripped = line.replaceAll("\\W", "");	// Replace everything that is a not a-z, 0-9
			stripped = stripped.toLowerCase();				// Why don't we just modify the input String?
															// Strings are immutable, we can't do that
			return stripped;
		}

		/* Now we use two stacks to test for palindrome qualities */
		public static boolean testPalin(String line){

			MyStack<String> normal 	 = new MyStack<>();	// Check for errors here
			MyStack<String> reversed = new MyStack<>();
			
			boolean palinTest = false;

			// Give normal stack each individual character in the string
			for (char c: line.toCharArray()){
				normal.push(Character.toString(c));
			}
			// Give reversed stack each individual character in reversed order
			for (int i = line.length()-1; i > -1; i--){
				reversed.push(Character.toString(line.charAt(i)));
			}
			for (int i = 0; i < normal.size(); i++) {
				if (normal.get(i).equals(reversed.get(i)) == false) {
					palinTest = false;
					break; //
				}else {
					palinTest = true;
				}
			}

			return palinTest;
		}
}

