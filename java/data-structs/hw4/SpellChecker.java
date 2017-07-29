
/**
 * Jason Perez
 * UNI: jp3476
 * HW4
 * 
 * Works with files included in the hw directory
 * Used Eclipse environment to input command line arguments
 */

import java.io.*;
import java.util.*;

public class SpellChecker {

	private int line;
	private char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	public static HashSet<String> dictionary = new HashSet<>();

	public SpellChecker(Scanner words, Scanner sampleWords) {

		while (words.hasNextLine()) {

			String word = words.nextLine();
			word = word.toLowerCase();

			dictionary.add(word);
		}

		while (sampleWords.hasNextLine()) {

			line++;
			Scanner s2 = new Scanner(sampleWords.nextLine());
			while (s2.hasNext()) {

				String sampleWord = s2.next();
				sampleWord = removeNon(sampleWord.toLowerCase());
				boolean checkTable = SpellCheck(sampleWord);

				if (!checkTable) {
					System.out.println("Mispelled Word: " + sampleWord);
					System.out.println("LineNumber: " + line);
					System.out.println("Suggestions: ");

					// Print out All suggestions

					Set<String> map = printSuggestions(charAppend(sampleWord),
							charDelete(sampleWord), charSwap(sampleWord));

					System.out.println(map);
				}
			}
		}

	}

	// Returns a set of all possible suggestions
	// No duplicates!
	public Set<String> printSuggestions(ArrayList<String> input,
			ArrayList<String> input2, ArrayList<String> input3) {

		Set<String> allSuggestions = new HashSet<String>();

		if (input.size() != 0) {
			for (int i = 0; i < input.size(); i++) {
				allSuggestions.add(input.get(i));
			}
		}
		if (input2.size() != 0) {
			for (int i = 0; i < input2.size(); i++) {
				allSuggestions.add(input2.get(i));
			}
		}
		if (input3.size() != 0) {
			for (int i = 0; i < input3.size(); i++) {
				allSuggestions.add(input3.get(i));
			}

		}
		return allSuggestions;
	}

	// Check if word is mispelled by using contains()
	public boolean SpellCheck(String doc) {

		if (isInteger(doc)) {
			return true;
		}
		boolean x = dictionary.contains(doc);
		return x;
	}

	// A method to determine whether a given string is an integer
	// Returns false if not integer
	public static boolean isInteger(String str) {
		if (str == null) {
			return false;
		}
		int length = str.length();
		if (length == 0) {
			return false;
		}
		int i = 0;
		if (str.charAt(0) == '-') {
			if (length == 1) {
				return false;
			}
			i = 1;
		}
		for (; i < length; i++) {
			char c = str.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}

	// Suggestion methods for given mispelled word

	public ArrayList<String> charAppend(String word) {

		// Input -> word = "clas"
		ArrayList<String> suggestions = new ArrayList<>();

		for (int i = 0; i < word.length() + 1; i++) {

			for (int j = 0; j < alphabet.length; j++) {
				StringBuilder str = new StringBuilder(word);
				str.insert(i, alphabet[j]);
				if (SpellCheck(str.toString())) {
					suggestions.add(str.toString()); // Add to set
				}
			}
		}
		return suggestions;
	}

	// Remove Character and Check Method
	public ArrayList<String> charDelete(String word) {

		ArrayList<String> suggestions = new ArrayList<>();

		for (int i = 0; i < word.length(); i++) {
			StringBuilder str = new StringBuilder(word);
			str.deleteCharAt(i);
			if (SpellCheck(str.toString())) {
				suggestions.add(str.toString()); // Add to allSuggestions
			} // check
		}
		return suggestions;
	}

	// Swap adjacent character and check method

	public ArrayList<String> charSwap(String word) {

		ArrayList<String> suggestions = new ArrayList<>();

		for (int i = 0; i < word.length() - 1; i++) {

			char[] c = word.toCharArray();

			// Replace with a "swap" function, if desired:
			char temp = c[i];
			c[i] = c[i + 1];
			c[i + 1] = temp;

			String swappedString = new String(c);

			if (SpellCheck(swappedString)) {
				suggestions.add(swappedString);
			}

		}
		return suggestions;
	}

	public String removeNon(String word) {

		String removed = word.replaceAll("[^A-z0-9]+$", "")
				.replaceAll("^[^A-z0-9]+", "");
		return removed;
	}

	public static void main(String[] args) {

		try {
			Scanner words = new Scanner(new File(args[0]));
			Scanner sampleWords = new Scanner(new File(args[1]));

			SpellChecker test = new SpellChecker(words, sampleWords);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}