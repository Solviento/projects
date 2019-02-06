import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class displayShape extends JPanel {
	
    ArrayList<Shape> shapelist = new ArrayList<Shape>();
    
    public void add(Shape shape) {
    	shapelist.add(shape);
    }
    
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
		for (Shape s: shapelist){
			s.draw(g);
		}
    }
}
