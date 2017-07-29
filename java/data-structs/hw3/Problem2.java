
//Jason Perez
//UNI: jp3476

import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.LinkedList;

public class Problem2 {

	public static void main(String[] args) {

		// Code I used from an earlier java assignment
		Scanner in = new Scanner(System.in);
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

		// Input goes into scanner. While loop will take each line of text
		// and push it into the LinkedList to be parsed through
		File inputFile = new File(filename);
		Scanner in = new Scanner(inputFile);
		LinkedList<String> line = new LinkedList<>();

		while (in.hasNextLine()) {
			String textLine = in.nextLine();
			line.add(textLine);
		}
		in.close();

		AvlTree<String> finalTree = printAvlTree(line); // Tree is created using
														// LinkedList object
		finalTree.printTree();
	}

	public static AvlTree<String> printAvlTree(LinkedList<String> line) {

		AvlTree<String> tree = new AvlTree<>(); // Creates avl tree

		for (int i = 0; i < line.size(); i++) {

			String text = line.get(i);
			// StringTokenizer was recommended by Computer Science Assistant
			StringTokenizer tokens = new StringTokenizer(text);
			// Will break string into string "tokens"

			while (tokens.hasMoreTokens()) {
				// Parse through tokens and remove all punctuation, force
				// lowercase
				String singleToken = tokens.nextToken();

				singleToken = singleToken.replaceFirst("^[^a-zA-Z']+", "")
						.replaceAll("[^a-zA-Z']/+$", "").toLowerCase();
				tree.insert(singleToken, i + 1);
				// Insert word and line number into avl tree
			}
		}
		return tree;
	}

}
