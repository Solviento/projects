import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class shapeTester {

	public static void main(String... args){
		// User input dialog box
		String input = JOptionPane.showInputDialog("Enter width:");
		String input2 = JOptionPane.showInputDialog("Enter height:");
		// Parse user input
		int width = Integer.parseInt(input);	
		int height = Integer.parseInt(input2); 
		
		JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(width, height);
        
        int midx = width/2;
        int midy = height/2;
        
        // FOR PART2 
        Shape c = new Circle(midx, 30, Color.cyan, 30); 
        Shape t = new Polygon(midx, 130, Color.green, 40, 3);
        Shape p = new Polygon(midx, 220, Color.yellow, 40, 5);
        Shape o = new Polygon(midx, 300, Color.orange, 30, 8);
        
        
        shapeList list = new shapeList();
        list.add(c);
        list.add(t);
        list.add(p);
        list.add(o);
        frame.add(list);
        // END PART2
        
        // FOR PART3
        shapeList listconcentric = new shapeList();

        if (height<width){
        	Shape c4 = new Circle(midx, midy, Color.yellow, height/2); 
            Shape c3 = new Circle(midx, midy, Color.green, height/3);
            Shape c2 = new Circle(midx, midy, Color.white, height/4);
            Shape c1 = new Circle(midx, midy, Color.orange, height/5);

            Shape p3 = new Polygon(midx, midy, Color.gray, height/2, 5);
            Shape p2 = new Polygon(midx, midy, Color.pink, height/3, 5);
            Shape p1 = new Polygon(midx, midy, Color.magenta, height/4, 5);

            listconcentric.add(c4);
            listconcentric.add(p3);
            listconcentric.add(c3);
            listconcentric.add(p2);
            listconcentric.add(c2);
            listconcentric.add(p1);
            listconcentric.add(c1);
            
            frame.add(listconcentric);	// comment to display part2
        }
        if (height>width){
        	Shape c4 = new Circle(midx, midy, Color.yellow, width/2); 
            Shape c3 = new Circle(midx, midy, Color.green, width/3);
            Shape c2 = new Circle(midx, midy, Color.white, width/4);
            Shape c1 = new Circle(midx, midy, Color.orange, width/5);

            Shape p3 = new Polygon(midx, midy, Color.gray, width/2, 5);
            Shape p2 = new Polygon(midx, midy, Color.pink, width/3, 5);
            Shape p1 = new Polygon(midx, midy, Color.magenta, width/4, 5);

            listconcentric.add(c4);
            listconcentric.add(p3);
            listconcentric.add(c3);
            listconcentric.add(p2);
            listconcentric.add(c2);
            listconcentric.add(p1);
            listconcentric.add(c1);
            
            frame.add(listconcentric);	// comment to display part 2
        }
        // END PART3 
        
	}
}
