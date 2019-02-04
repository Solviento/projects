import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	private int width;
	private int height;
	// constructor
	public Rectangle(int x, int y, Color c, int w, int h) {
		super(x, y, c);
		width = w;
		height = h;
	}
	// accessor methods
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	@Override
	public int getArea() {
		return width*height;
	}
	@Override
	public int getPerimeter() {
		return (width*2)+(height*2);
	}
	@Override
	public String toString() {
		return 	"Width: " + getWidth() + " Height: " + getHeight()+
				" Perimeter: " + getPerimeter() +
				" Area: " + getArea();
	}
	@Override
	public void draw(Graphics g) {
		super.paintComponent(g);
		g.setColor(getColor());
		g.fillRect(getX()-(width/2), getY()-(height/2), width, height);
	}
	@Override
	public Rectangle getBoundingBox() {
		Rectangle r = new Rectangle(getX(), getY(), getColor(), width, height);
		
		return r;
	}

}
