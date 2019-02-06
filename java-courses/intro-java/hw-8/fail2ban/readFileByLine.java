import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class readFileByLine {
	public static void main(String fileName) {
		try {
		File file = new File("logs_processed.txt");
		Scanner scanner = new Scanner(file).useDelimiter("\\n);");
		while (scanner.hasNext()) {
		    System.out.println(scanner.nextLine());
		}	
		scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
}
