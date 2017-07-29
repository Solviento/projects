import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame; 													//handle the display 
import javax.swing.JOptionPane;

public class hw1 {

		public static void main(String[] args){
			
			String input = JOptionPane.showInputDialog("Enter width:");		// User input dialog box
			String input2 = JOptionPane.showInputDialog("Enter height:");
			int width = Integer.parseInt(input);							// Parse user input
			int height = Integer.parseInt(input2);

			Shapes panel = new Shapes(height, width);						// Create shape object w saved int choice
			
			JFrame application = new JFrame();								// Application box
			
			application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			application.add(panel);	
			application.setSize(width, height);								// Box frame
			application.setVisible(true);
			
		}
}

