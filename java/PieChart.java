import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PieChart extends Circle{
	
	private int startingAngle;
	private int arcAngle;
	private String legend;
	
	public PieChart(int x, int y, Color c, int radius, int start, int intA, String s){
		super(x, y, c, radius);
		startingAngle = start;
		arcAngle = intA;
		legend = s;
	}
	public void draw(Graphics g){
		super.paintComponent(g);		
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(getColor());	
		// draw arc
		g2.fillArc(getX()/2, getY()/2, getX(), getY(), startingAngle, arcAngle);
		// set text color to black
		g.setColor(Color.black);
		// keeps track of which quadrant we are in
		int arcSum = startingAngle+arcAngle;
		if (arcSum <= 90){
			g2.drawString(legend, (int)(getX()+(5+getRadius()/2.4)*Math.cos(Math.toRadians(startingAngle+arcAngle/2))), (int)(getY()-(5+getRadius()/2.2)*Math.sin(Math.toRadians(startingAngle+arcAngle/2))));
		}
		if ((arcSum > 90) && (arcSum <= 180)){
			g2.drawString(legend, (int)(getX()+(55+getRadius()/2.4)*Math.cos(Math.toRadians(startingAngle+arcAngle/2))), (int)(getY()-(5+getRadius()/2.2)*Math.sin(Math.toRadians(startingAngle+arcAngle/2))));
		}
		if ((arcSum > 180) && (arcSum <= 270)){
			g2.drawString(legend, (int)(getX()+(70+getRadius()/2.4)*Math.cos(Math.toRadians(startingAngle+arcAngle/2))), (int)(getY()-(5+getRadius()/2.2)*Math.sin(Math.toRadians(startingAngle+arcAngle/2))));
		}
		// rotate and unrotate text strings in fourth quadrant
		if (arcSum > 270){
			int origx = (int)(getX()+(5+getRadius()/2.4)*Math.cos(Math.toRadians(startingAngle+arcAngle/2)));
			int origy = (int)(getY()-(5+getRadius()/2.2)*Math.sin(Math.toRadians(startingAngle+arcAngle/2)));
			g2.rotate(Math.toRadians(6*Math.PI), origx, origy);
			g2.drawString(legend, (int)(getX()+(5+getRadius()/2.4)*Math.cos(Math.toRadians(startingAngle+arcAngle/2))), (int)(getY()-(5+getRadius()/2.2)*Math.sin(Math.toRadians(startingAngle+arcAngle/2))));
			g2.rotate(-Math.toRadians(6*Math.PI), origx, origy);
		}
		// for reference purposes
		g.drawRect(0, 0, 500, 500);
	}

}
