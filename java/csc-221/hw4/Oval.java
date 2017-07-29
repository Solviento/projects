import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Shape{

	private int aRadius;
	private int bRadius;
	// constructor, uses a for major axis, b for minor axis
	public Oval(int x, int y, Color c, int a, int b) {
		super(x, y, c);
		aRadius = a;
		bRadius = b;
	}
	// accessors
	public int getARadius(){
		return aRadius;
	}
	public int getBRadius(){
		return bRadius;
	}
	public int getArea(){
		return (int) (aRadius*bRadius*Math.PI);
	}

	@Override
	public int getPerimeter() {
		// ellipse perimeter approximation formula
		double x = (Math.pow(aRadius, 2) + Math.pow(bRadius, 2))/2;
		return (int) (2*Math.PI*Math.sqrt(x));
	}

	@Override
	public String toString() {
		return "Major axis: " + aRadius + " Minor Axis: " +
				bRadius + " Perimeter: " + getPerimeter() +
				" Area: " + getArea();
	}
	@Override
	public void draw(Graphics g) {
		super.paintComponent(g);
		g.setColor(getColor());
		g.fillOval(getX()-(aRadius/2), getY()-(bRadius/2), aRadius, bRadius);
		
		g.setColor(Color.black);
		g.drawRect(0, 0, 1000, 500);
		g.drawLine(0, 0, 1000, 500);
		
	}
	@Override
	public Rectangle getBoundingBox() {
		Rectangle r = new Rectangle(getX(), getY(), getColor(), aRadius, bRadius);
		return r;
	}

}
