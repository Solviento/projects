import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Area;
import javax.swing.JPanel;

public abstract class Shape extends JPanel implements ShapePositionInterface{
	
	// every shape (circle, poly) has a center (x,y) and color attribute
	private int x;
	private int y;
	private Color c;
	
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
	// returns the point (x, y)
	public int[] getPoint(){
		int[] point = {x, y};
		return point;
	}
	// returns distance from point(x, y) to a point
	public int distanceTo(int x, int y){
		// euclidean distance formula
		double distance = Math.sqrt(Math.pow((getX()-x), 2) + Math.pow((getY()-y), 2));
		
		return (int)distance;
	}
	// each shape subclass will override this call
	public abstract String toString();
	
	// draws shape on drawing panel
	public abstract void draw(Graphics g);
	
	// uses Area API to detect an intersection of Shape objects
	public boolean doOverlap(Shape A, Shape B){
		Area areaA = new Area((java.awt.Shape) A);
		areaA.intersect(new Area((java.awt.Shape) B));
		if (areaA.isEmpty()){
			return true;
		}
		else{
			return false;
		}
	}
}
