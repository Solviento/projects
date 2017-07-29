import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape{

	private int radius;
	
	public Circle(int x, int y, Color c, int radius) {
		super(x, y, c);
		this.radius = radius;
	}
	public int getArea(){
		// formula for circle circumference
		return (int)((Math.PI)*(Math.pow(radius, 2)));	
	}
	public int getPerimeter(){
		return (int)(2*Math.PI*radius);
	}
	
	public int getRadius(){
		return radius;
	}
	
	public String toString() {
		return "Radius: " + radius + " Perimeter: " 
				+ getPerimeter() + " Area: " 
				+ getArea();
	}
	public void draw() {
		// circle object does not require coordinates array
		System.out.println(toString());
	}
	public void draw(Graphics g){
		super.paintComponent(g);
		g.setColor(getColor());
		g.fillOval(getX()-radius, getY()-radius, radius*2, radius*2);
		g.setColor(Color.black);
		g.drawString(toString(),getX()-radius,getY()+getRadius()); 
	}

}
