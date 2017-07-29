import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public abstract class Shape extends JPanel {
	
	// every shape (circle, poly) has a center (x,y)
	private int x;
	private int y;
	private Color c;
	
	// a abstract class cannot be instantiated, however we can do:
	// Shape s = new Polygon() which is:
	// abstractClass a = new concreteSubclass()
	
	// constructor
	public Shape(int x, int y, Color c){
		this.x = x;
		this.y = y;
		this.c = c;
	}
	// accessors
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public Color getColor(){
		return c;
	}
	// mutators
	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public void setColor(Color c){
		this.c = c;
	}
	// move center (x,y)
	public void moveTo(int deltx, int delty){
		x += deltx;
		y += delty;
	}
	// must be overridden by each subclass
	public abstract String toString();
	
	public abstract void draw();
	
	public abstract void draw(Graphics g);;
}
