import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

public class fail2ban {

	public static void main(String[] args) {

		boolean done = false;
		while (!done) {
			try {
			String filename = args[0];
			readFile(filename);
			done = true;
			} catch (FileNotFoundException exception) {
			System.out.println("File not found.");
			} catch (NoSuchElementException exception) {
			System.out.println("File contents invalid.");
			} catch (IOException exception) {
			exception.printStackTrace();
			}
		}
	}
	public static void readFile(String filename) throws IOException {
		String invalidTerm = "Invalid";
		ArrayList<String> textLine = new ArrayList<String>();
		ArrayList<String> invalidAddressList = new ArrayList<String>();
		File inputFile = new File(filename);
		Scanner in = new Scanner(inputFile);
																									while (in.hasNext()) {

			String addLine = in.nextLine();
			textLine.add(addLine); // Works! Each line is now read!
		}
		in.close();
		for (int i = 0; i < textLine.size(); i++) {
			String lineOf = textLine.get(i); // Get (i) string from arrayList
			int intIndex = lineOf.indexOf(invalidTerm); // Get index of "from"
			if (intIndex > -1) {
			String badIP = extractIP(lineOf); // RETURNS STRINGS OF BAD IPs
			// Now put all bad IP addresses into arrayList
			invalidAddressList.add(badIP);
			}
		}
		outputBan(invalidAddressList);
	}
	public static String extractIP(String textLine) throws IOException {
	// This method will receive a line of text containing "Invalid"
			String wrongIP = textLine; // ALL LINES HERE ARE INVALID IPs
			String extractedIP = "";
		int intIndex = wrongIP.indexOf("from");
		// Must now find IP index by adding 5
		int intIP = intIndex + 5;
	// Now extract String values until end of String line
		for (int i = intIP; i < wrongIP.length(); i++) {
			extractedIP += Character.toString(wrongIP.charAt(i));
		}
		return extractedIP;
	}
	public static void outputBan(ArrayList<String> textLine)
		throws FileNotFoundException {
		// Write output file using printWriter
		PrintWriter banFile = new PrintWriter("ban.txt");
		Set<String> set = new HashSet<String>();
		int counter = 0;
		ArrayList<String> lineList = new ArrayList<String>(textLine);
		// Nested loop to search duplicates
		for (int i = 0; i < lineList.size(); i++) {
			String searchWord = textLine.get(i);
		for (int j = i + 1; j < lineList.size(); j++) {
			String sameWord = lineList.get(j);
			// Compares search words and adds to counter -> counter is reset
			if (sameWord.equals(searchWord)) {
				counter += 1;
				if (counter > 3) {
				set.add(sameWord);
				counter = 0;
				}
			}
		}
	}
	// Writes all bad IPs to output file
	for (String s : set) {
		banFile.println(s);
	}
	banFile.close();
	}
}
